package execution.api;

import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiConfig {
    private static final String CLIENT_ID = "cmnGMnGPVKLJwWLfWxqFCSZOR5hIjhWb";
    private static final String CLIENT_SECRET = "uKCYJXAVkLY5gsWt";
    private static String token;

    private ApiConfig() {
    }

    public static void setToken() {

        config = config().encoderConfig(
                EncoderConfig.encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false));

        baseURI = "https://colsubsidio-test.apigee.net";

        Response tin = given()
                .auth().preemptive()
                .basic(CLIENT_ID, CLIENT_SECRET)
                .queryParam("grant_type", "client_credentials")      // ②  parámetro en la URL
                .log().uri()                                         // imprime URL completa
                .when()
                .post("/oauth/client_credential/accesstoken")        // ③  misma ruta
                .then()
                .log().all()
                .extract().response();

        Map<String, String> value = tin.jsonPath().get();
        token = value.get("access_token");
    }

    public static String getAccessToken() {
        if (token == null) {
            setToken();
        }
        return token;
    }
}