package execution.tests;


import execution.api.ServicesUtils;
import execution.data.DataProviderUtil;
import execution.enums.EnumDocumentTypeServices;
import io.restassured.response.Response;
import org.example.models.PreApprovedResponse;
import org.example.models.ValidationResponse;
import org.example.models.ValidatorRightsResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reports.ExtentLogger;
import utils.baseTest.BaseRequest;

import java.util.Map;

import static execution.api.ApiConfig.getAccessToken;
import static reports.ExtentManager.getExtentTest;

public class ApiTest extends BaseRequest {
    private static final String VARIABLE = "https://platform-test-external.colsubsidio.com";
    private String baseApigee;
    private String basePlatformExt;
    private String basePlatformInt;
    private String apiKey;
    private String token;

    @BeforeTest()
    public void beforeTest() {
        baseApigee = "https://colsubsidio-test.apigee.net";
        basePlatformInt = "https://platform-test-internal.colsubsidio.com";
        basePlatformExt = "https://platform-test-external.colsubsidio.com";
    }


    @Test(enabled = true, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class)
    public void testValidationServices(
            String typeDocument,
            String identification
    ) {
        boolean isAffiliate = ServicesUtils.isAffiliate("CO1C", identification);

        if (isAffiliate) {
            ExtentLogger.pass("the user " + typeDocument + " " + identification + " is affiliate and titular");
        } else {
            ExtentLogger.fail("the user " + typeDocument + " " + identification + " is <b>NOT</b> affiliate or titular");
        }

        boolean hasCredentialsSSO = ServicesUtils.hasCredentialsSSO("CO1C", identification);
        if (hasCredentialsSSO) {
            ExtentLogger.pass("the user " + typeDocument + " " + identification + " has SSO password ");
        } else {
            ExtentLogger.fail("the user " + typeDocument + " " + identification + " has <b>NOT</b> affiliate or titular");
        }
        ExtentLogger.info("<hr style='border:1px solid #ccc;'>");
        /////////////////////////////////////////////////////////////////////////////////////////////
        String token = getAccessToken();
        Map<String, String> params = Map.of(
                "numeroId", identification,
                "tipoId", EnumDocumentTypeServices.getCode(typeDocument).getValue()
        );
        Map<String, String> headers = Map.of(
                "accept", "application/json",
                "Authorization", "Bearer " + token
        );

        Response response = requestGet(baseApigee + "/api/v2/afiliacion/validador", headers, params);
        Assert.assertEquals(response.getStatusCode(), 200, "The service Validator Rights is failing");
        ValidatorRightsResponse validatorRightsResponse = response.as(ValidatorRightsResponse.class);
        reportValidatorRights(validatorRightsResponse, identification);
        ExtentLogger.info("<hr style='border:1px solid #ccc;'>");
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        headers = Map.of(
                "x-api-key", "rRXXnTUnej71MueSIqZdV91GgXe0tEIZ1kkV0B3h"
        );
        String json = """
                {"documento": { "tipo": "%s", "numero": "%s" }}
                """.formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification);

        response = requestPost(basePlatformInt + "/loans/eligibility/external/v1/card-validations", headers, null, json);
        Assert.assertEquals(response.getStatusCode(), 200, "The service CARD VALIDATIONS is failing");
        ValidationResponse validationResponse = response.as(ValidationResponse.class);
        reportValidationCards(validationResponse, typeDocument, identification);

        /////////////////////////////////////////////////////////////////////////
        String body = """ 
                {"numeroDocumento" : "%s", "tipoDocumento": "%s"}
                """.formatted(identification, EnumDocumentTypeServices.getCode(typeDocument).getValue());

        headers = Map.of(
                "Authorization", "Bearer " + token,
                "accept", "application/json",
                "content-type", "application/json"
        );

        response = requestPost(baseApigee + "/api/v2/credito/elegibilidad/listasrestrictivas", headers, null, body);
        Assert.assertEquals(response.getStatusCode(), 200, "the service restrictive list is not working");
        validationResponse = response.as(ValidationResponse.class);
        reportValidationListRestrictive(validationResponse, typeDocument, identification);
        ExtentLogger.info("<hr style='border:1px solid #ccc;'>");

        /// /////////////////////////////////////////////////////////////////////

        response = requestGet(basePlatformExt + "/loans/loans/external/v1/preapproved/CO1C/" + identification, null, null);
        Assert.assertEquals(response.getStatusCode(), 200, "Status should be 200");
        PreApprovedResponse preApprovedResponse = response.as(PreApprovedResponse.class);
        reportPreapproved(preApprovedResponse, typeDocument, identification);
    }

    private void reportPreapproved(PreApprovedResponse preApprovedResponse, String typeDocument, String identification) {
        if (getExtentTest() != null) {
            ExtentLogger.pass("The <b>service preapproved</b> is working correctly");
            if (preApprovedResponse.getData().isHasCredit()) {
                ExtentLogger.info("The user " + typeDocument + " " + identification + " has <b>PREAPPROVED</b>");
            } else {
                ExtentLogger.info("The user " + typeDocument + " " + identification + " has <b>NOT PREAPPROVED</b>");
            }
            ExtentLogger.infoJsonPretty(preApprovedResponse.getData());
        }
    }

    private void reportValidatorRights(ValidatorRightsResponse validatorRightsResponse, String identification) {
        if (getExtentTest() != null) {
            ExtentLogger.pass("The <b>service validate rights</b> is working");
            if (!validatorRightsResponse.getData().isEmpty()) {
                if (validatorRightsResponse.getData().get(0).getAfiliado().getEstado().equals("RETIR")) {
                    ExtentLogger.fail("the user" + "CC" + " " + identification + " is <b>RETIRED</b>");
                } else if (validatorRightsResponse.getData().get(0).getAfiliado().getEstado().equals("VIGEN")) {
                    ExtentLogger.pass("the user" + "CC" + " " + identification + " is <b>ViGENT</b>");
                }
                if (validatorRightsResponse.getData().get(0).getAfiliado().getNumeroDocumento().equals(identification)) {
                    ExtentLogger.pass("the user" + "CC" + " " + identification + " is <b>TITULAR</b>");
                } else {
                    ExtentLogger.fail("the user" + "CC" + " " + identification + " is N <b> NOT TITULAR</b>");
                }
                ExtentLogger.infoJsonPretty(validatorRightsResponse.getData());
            } else {
                ExtentLogger.fail("The user is  <b>NOT</b> affiliate");
            }
        } else {
            ExtentLogger.fail("The user is  <b>NOT</b> affiliate");
        }
    }


    private void reportValidationCards(ValidationResponse validationResponse, String typeDocument, String identification) {
        if (getExtentTest() != null) {
            ExtentLogger.pass("The <b>service validate cards</b> is validating the user");
            String state = validationResponse.getResultadoValidacion().getEstado();
            if (state.equals("OK")) {
                ExtentLogger.pass("The user " + typeDocument + " " + identification + " pass the ASKARD validations");
            } else if (state.equals("VALIDATION_ERROR")) {
                ExtentLogger.fail("The user " + typeDocument + " " + identification + " NOT pass the ASKARD validations");
                String codeValidation = validationResponse.getResultadoValidacion().getDatosError().getCodigoErrorValidacion();
                if (codeValidation.equals("CARD_STATUS")) {
                    ExtentLogger.fail("The user has not CARD");
                } else if (codeValidation.equals("INVALID_REQUIREMENTS")) {
                    ExtentLogger.fail("The user has a active CARD with some state or amparada");
                }
            } else {
                ExtentLogger.info("the state is not recognized");
            }
            ExtentLogger.infoJsonPretty(validationResponse.getResultadoValidacion());
        }
    }

    private void reportValidationListRestrictive(ValidationResponse validationResponse, String typeDocument, String identification) {
        if (getExtentTest() != null) {
            ExtentLogger.pass("The <b>service restrictive cards</b> is validating the user");
            String state = validationResponse.getResultadoValidacion().getEstado();
            if (state.equals("OK")) {
                ExtentLogger.pass("The user " + typeDocument + " " + identification + " pass the LIST RESTRICTIVE validations");
            } else if (state.equals("VALIDATION_ERROR")) {
                ExtentLogger.fail("The user " + typeDocument + " " + identification + " <b>NOT</b> pass LIST RESTRICTIVE validations");
                String codeValidation = validationResponse.getResultadoValidacion().getDatosError().getCodigoErrorValidacion();
            } else {
                ExtentLogger.info("the state is not recognized");
            }
            ExtentLogger.infoJsonPretty(validationResponse.getResultadoValidacion());
        }
    }


    @Test(enabled = false, dataProviderClass = DataProviderUtil.class, dataProvider = "fillDataApi", priority = 4)
    public void getOffers(
            String typeDocument,
            String identification
    ) {
        Map<String, String> headers = Map.of(
                "Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQMTAzMDU5MzU5Nl8yIiwiY3VzdG9tZXIiOnsiZG9jdW1lbnROdW1iZXIiOiIxMDMwNTkzNTk2IiwiZG9jdW1lbnRUeXBlIjoiMiIsInRva2VuSWQiOiJBUUlDNXdNMkxZNFNmY3g3Ym5SczAycUpSMVZ6alNfNHJFVk01ZzZ4c2tXd0Y0WS4qQUFKVFNRQUNNREVBQWxOTEFCUXROekl6TWpVNE1USXdNVGcxT1RFNU56UTBOUS4uKiIsInRlbGVwaG9uZU51bWJlciI6Iis1NzMyMjM5ODQwOTYiLCJtYWlsIjoicHJ1ZWJhcmV0b21hOEBwb3dlcnNjcmV3cy5jb20iLCJ0aW1lU2Vzc2lvbiI6IjYwIiwidXNlcm5hbWUiOiJQMTAzMDU5MzU5Nl8yIiwiZmlyc3ROYW1lIjoiUHJ1ZWJhIiwibGFzdE5hbWUiOiJyZXQifSwiaWF0IjoxNzU1NjI0NDM0LCJleHAiOjE3NTU2MjgwMzR9.vXOBqYAmjUM_iXkdxCMgfp_exra2-DRVITa58Jvdg7y5aB-h5Xr3juPy_6YFRgfZ6vWaWAMKqCbNQCP9rfjQ9A",
                "accept", "application/json",
                "content-type", "application/json"
        );

        Response response = requestGet("https://platform-test-external.colsubsidio.com/loans/loan-offer/external/v1/product/2/request/offer/177601", headers, null);
        Assert.assertEquals(response.getStatusCode(), 200, "the service restrictive list is not working");
        var data = response.jsonPath();
    }
}

