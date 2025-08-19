package execution.tests;


import execution.api.ServicesUtils;
import execution.data.DataProviderUtil;
import io.restassured.response.Response;
import org.example.models.PreApprovedResponse;
import org.example.models.CardValidationResponse;
import org.example.models.ValidatorRightsResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reports.ExtentLogger;
import utils.baseTest.BaseRequest;

import java.util.HashMap;
import java.util.Map;

import static execution.api.ApiConfig.getAccessToken;
import static io.restassured.RestAssured.*;
import static reports.ExtentManager.getExtentTest;

public class ApiTest extends BaseRequest {
    private static final String VARIABLE = "https://platform-test-external.colsubsidio.com";

    @BeforeTest()
    public void beforeTest() {
    }


    @Test(enabled = true, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class, priority = 1)
    public void testPreapproved(
            String typeDocument,
            String identification
    ) {
        Response response = requestGet("https://platform-test-external.colsubsidio.com/loans/loans/external/v1/preapproved/CO1C/" + identification, null, null);
        Assert.assertEquals(response.getStatusCode(), 200, "Status should be 200");
        PreApprovedResponse preApprovedResponse = response.as(PreApprovedResponse.class);
        reportPreapproved(preApprovedResponse, typeDocument, identification);
    }

    @Test(enabled = true, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class)
    public void testValidatorRights(
            String typeDocument,
            String identification
    ) {
        Boolean isAffiliate = ServicesUtils.isAffiliate("CO1C", identification);
        String token = getAccessToken();
        Map<String, String> params = Map.of(
                "numeroId", identification,
                "tipoId", "CO1C"
        );
        Map<String, String> headers = Map.of(
                "accept", "application/json",
                "Authorization", "Bearer " + token
        );

        Response response = requestGet("https://colsubsidio-test.apigee.net/api/v2/afiliacion/validador", headers, params);
        Assert.assertEquals(response.getStatusCode(), 200, "The service Validator Rights is failing");
        ValidatorRightsResponse validatorRightsResponse = response.as(ValidatorRightsResponse.class);
        reportValidatorRights(validatorRightsResponse, identification);
    }

    @Test(enabled = true, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class, priority = 3)
    public void testCardValidations(
            String typeDocument,
            String identification
    ) {
        baseURI = "https://platform-test-internal.colsubsidio.com";
        Map<String, String> headers = new HashMap<>();
        headers.put("x-api-key", "rRXXnTUnej71MueSIqZdV91GgXe0tEIZ1kkV0B3h");

        String json = "{\n" +
                "  \"documento\": {\n" +
                "    \"tipo\": \"CO1C\",\n" +
                "    \"numero\": \"" + identification + "\"\n" +
                "  }\n" +
                "}";

        Response response = requestPost("https://platform-test-internal.colsubsidio.com/loans/eligibility/external/v1/card-validations", headers, null, json);
        Assert.assertEquals(response.getStatusCode(), 200, "The service CARD VALIDATIONS is failing");
        CardValidationResponse cardValidationResponse = response.as(CardValidationResponse.class);
        reportValidationCards(cardValidationResponse, typeDocument, identification);
    }

    @Test(enabled = true, dataProviderClass = DataProviderUtil.class, dataProvider = "fillDataApi", priority = 4)
    public void restrictiveList(
            String typeDocument,
            String identification
    ) {
        String token = getAccessToken();
        baseURI = "https://colsubsidio-test.apigee.net/api/v2/credito/elegibilidad/listasrestrictivas";
        Map<String, String> headers = new HashMap<>();
        String body = "{\n" +
                "  \"numeroDocumento\": \"1030691913\",\n" +
                "  \"primerNombre\": \"EDWIN\",\n" +
                "  \"primerApellido\": \"GUERRERO\",\n" +
                "  \"numeroDocumentoEmpresa\": \"" + identification + "\"\n" +
                "}";

        headers.put("Authorization", "Bearer " + token);
        headers.put("accept", "application/json");
        headers.put("content-type", "application/json");

        Response response = requestPost("https://colsubsidio-test.apigee.net/api/v2/credito/elegibilidad/listasrestrictivas", headers, null, body);
        var data = response.jsonPath();
        Integer code = response.getStatusCode();
        if (code != 200) {

        }

        if (getExtentTest() != null) {
            if (code.equals(200)) {
                ExtentLogger.pass("The service <b>restrictive list</b> is working correctly");
            } else {
                ExtentLogger.fail("The service <b>restrictive list</b> is NOT working correctly");
            }
        }
    }

    private void reportPreapproved(PreApprovedResponse preApprovedResponse, String typeDocument, String identification) {
        if (getExtentTest() != null) {
            ExtentLogger.pass("The service preapproved is working correctly");
            if (preApprovedResponse.getData().isHasCredit()) {
                ExtentLogger.info("The user " + typeDocument + " " + identification + " has preapproved");
                ExtentLogger.infoPretty(preApprovedResponse.getData());
            } else {
                ExtentLogger.fail("The user " + typeDocument + " " + identification + " has NOT preapproved");
            }
        }
    }

    private void reportValidatorRights(ValidatorRightsResponse validatorRightsResponse, String identification) {
        if (getExtentTest() != null) {
            ExtentLogger.pass("The service <b>validate rights</b> is working");
            if (!validatorRightsResponse.getData().isEmpty()) {
                ValidatorRightsResponse.Afiliado afiliado = validatorRightsResponse.getData().get(0).getAfiliado();
                ExtentLogger.pass("The user " + afiliado.getPrimerNombre() + " is affiliate " + afiliado.getTipoDocumento() + " " + afiliado.getNumeroDocumento());
                if (validatorRightsResponse.getData().get(0).getAfiliado().getNumeroDocumento().equals(identification)) {
                    ExtentLogger.pass("The user is titular");
                } else {
                    ExtentLogger.fail("The user is  <b>NOT</b> titular");
                }
            } else {
                ExtentLogger.fail("The user is  <b>NOT</b> affiliate");
            }
            ExtentLogger.infoPretty(validatorRightsResponse.getData());
        } else {
            ExtentLogger.fail("The user is  <b>NOT</b> affiliate");
        }
    }


    private void reportValidationCards(CardValidationResponse cardValidationResponse, String typeDocument, String identification) {
        if (getExtentTest() != null) {
            ExtentLogger.pass("The service validate cards is validating the user");
            String state = cardValidationResponse.getResultadoValidacion().getEstado();
            if (state.equals("OK")) {
                ExtentLogger.pass("The user " + typeDocument + " " + identification + " pass the ASKARD validations");
            } else if (state.equals("VALIDATION_ERROR")) {
                ExtentLogger.info("The user " + typeDocument + " " + identification + " NOT pass the ASKARD validations");
                String codeValidation = cardValidationResponse.getResultadoValidacion().getDatosError().getCodigoErrorValidacion();
                if (codeValidation.equals("CARD_STATUS")) {
                    ExtentLogger.fail("The user don't have CARD");
                } else if (codeValidation.equals("INVALID_REQUIREMENTS")) {
                    ExtentLogger.fail("The user have a active CARD with some state or amparada");
                }
                ExtentLogger.infoPretty(cardValidationResponse.getResultadoValidacion());
            } else {
                ExtentLogger.info("No identificado");
            }
        }
    }
}

