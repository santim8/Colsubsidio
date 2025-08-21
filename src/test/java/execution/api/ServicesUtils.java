package execution.api;

import execution.enums.EnumDocumentTypeServices;
import io.restassured.response.Response;
import org.example.models.ValidatorRightsResponse;
import java.util.Map;
import static execution.api.TokenManager.getAccessToken;
import static io.restassured.RestAssured.baseURI;
import static utils.baseTest.BaseRequest.requestGet;
import static utils.baseTest.BaseRequest.requestPost;

public class ServicesUtils {

    private static final String baseApigee = "https://colsubsidio-test.apigee.net";
    private static final String basePlatformExt = "https://platform-test-external.colsubsidio.com";
    private static final String basePlatformInt = "https://platform-test-internal.colsubsidio.com";

    public ServicesUtils() {
    }

    public static boolean isAffiliate(String typeDocument, String identification) {
        baseURI = "https://platform-test-external.colsubsidio.com";
        Map<String, String> params = Map.of(
                "documentNumber", identification,
                "documentType", EnumDocumentTypeServices.getCode(typeDocument).getValue()
        );
        try {
            Response response = requestGet("https://platform-test-external.colsubsidio.com/loans/clients/external/v1/validate-holder", null, params);
            if (response.getStatusCode() == 200) {
                return true;
            } else if (response.getStatusCode() == 404) {
                return false;
            }
            System.out.println("the service Validate Holder is failing");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean hasCredentialsSSO(String typeDocument, String identification) {
        String token = getAccessToken();
        String body = """
                {
                "contrasenha": "Colsubsidio2025.", 
                "documento": {
                    "tipo": "%s",
                    "numero": "%s"
                    }
                }""".formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification);

        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token,
                "accept", "application/json"
        );
        try {
            Response response = requestPost("https://colsubsidio-test.apigee.net/api/v2/autenticacion/usuarios/login/personas", headers, null, body);
            if (response.getStatusCode() == 200) {
                return true;
            } else if (response.getStatusCode() == 401) {
                return false;
            }
            System.out.println("the service Validate Holder is failing");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Response validatorRightsResponse(String typeDocument, String identification) {
        String token = getAccessToken();
        Map<String, String> params = Map.of(
                "numeroId", identification,
                "tipoId", EnumDocumentTypeServices.getCode(typeDocument).getValue()
        );
        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token
        );

        Response response = requestGet(baseApigee + "/api/v2/afiliacion/validador", headers, params);
        ValidatorRightsResponse validatorRightsResponse = response.as(ValidatorRightsResponse.class);
        return response;
    }


    public static Response validationCardsResponse(String typeDocument, String identification) {

        Map<String, String> headers = Map.of(
                "x-api-key", "rRXXnTUnej71MueSIqZdV91GgXe0tEIZ1kkV0B3h"
        );
        String json = """
                {"documento": { "tipo": "%s", "numero": "%s" }}
                """.formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification);

        return requestPost(basePlatformInt + "/loans/eligibility/external/v1/card-validations", headers, null, json);
    }

    public static Response validationListRestrictiveResponse(String typeDocument, String identification) {
        String token = getAccessToken();
        String body = """ 
                {"numeroDocumento" : "%s", "tipoDocumento": "%s"}
                """.formatted(identification, EnumDocumentTypeServices.getCode(typeDocument).getValue());

        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token
        );

        return requestPost(baseApigee + "/api/v2/credito/elegibilidad/listasrestrictivas", headers, null, body);
    }

    public static Response validationPreapprovedResponse(String typeDocument, String identification) {
        String re = basePlatformExt + "/loans/loans/external/v1/preapproved/%s/%s".formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification);
        return requestGet(basePlatformExt + "/loans/loans/external/v1/preapproved/%s/%s".formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification), null, null);
    }
}
