package execution.api;

import io.restassured.response.Response;

import java.util.Map;

import static execution.api.ApiConfig.getAccessToken;
import static io.restassured.RestAssured.baseURI;
import static utils.baseTest.BaseRequest.requestGet;
import static utils.baseTest.BaseRequest.requestPost;

public class ServicesUtils {


    public ServicesUtils() {
    }

    public static boolean isAffiliate(String typeDocument, String identification) {
        baseURI = "https://platform-test-external.colsubsidio.com";
        Map<String, String> params = Map.of(
                "documentNumber", identification,
                "documentType", typeDocument
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
        String body = "{\n" +
                "  \"contrasenha\": \"Colsubsidio2025.\",\n" +
                "  \"documento\": {\n" +
                "    \"tipo\": \"2\",\n" +
                "    \"numero\": \"" + identification + "\"\n" +
                "  }\n" +
                "}";
        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token,
                "accept", "application/json"
        );
        try {
            Response response = requestPost("https://colsubsidio-test.apigee.net/api/v2/autenticacion/usuarios/login/personas", headers, null, body);
            var resp = response.jsonPath();
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
}
