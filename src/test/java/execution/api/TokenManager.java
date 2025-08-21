package execution.api;

import execution.enums.EnumDocumentType;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import org.example.models.AuthenticationResponse;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static utils.baseTest.BaseRequest.requestPost;

public class TokenManager {
    private static final String CLIENT_ID = "cmnGMnGPVKLJwWLfWxqFCSZOR5hIjhWb";
    private static final String CLIENT_SECRET = "uKCYJXAVkLY5gsWt";
    private static String token;

    private TokenManager() {
    }

    public static void setToken() {

        config = config().encoderConfig(
                EncoderConfig.encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false));

        baseURI = "https://colsubsidio-test.apigee.net";

        Response response = given()
                .auth().preemptive()
                .basic(CLIENT_ID, CLIENT_SECRET)
                .queryParam("grant_type", "client_credentials")      // ②  parámetro en la URL
                .log().uri()                                         // imprime URL completa
                .when()
                .post("/oauth/client_credential/accesstoken")        // ③  misma ruta
                .then()
                .log().all()
                .extract().response();

        Map<String, String> value = response.jsonPath().get();
        token = value.get("access_token");
    }

    public static String getAccessToken() {
        if (token == null) {
            setToken();
        }
        return token;
    }

    public static String setTokenSSO(String typeDocument, String identification) {
        String token = getAccessToken();
        String body = """
                {
                "contrasenha": "Colsubsidio2025.", 
                "documento": {
                    "tipo": "%s",
                    "numero": "%s"
                    }
                }""".formatted(EnumDocumentType.getCode(typeDocument).getValue(), identification);

        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token,
                "accept", "application/json"
        );
        try {
            Response response = requestPost("https://colsubsidio-test.apigee.net/api/v2/autenticacion/usuarios/login/personas", headers, null, body);
            var tin = response.jsonPath();
            if (response.getStatusCode() != 200) {
                return null;
            }
            AuthenticationResponse authenticationResponse = response.as(AuthenticationResponse.class);
            return authenticationResponse.getObtenerToken().get(0).getToken();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String getAccessTokenSSO(String typeDocument, String identification) {
        if (token == null) {
            setTokenSSO(typeDocument, identification);
        }
        return token;
    }

    public static boolean hasCredentialsSSO(String typeDocument, String identification) {
        return getAccessTokenSSO(typeDocument, identification) != null;
    }

}