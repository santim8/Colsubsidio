package execution.api;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.bytebuddy.asm.MemberSubstitution;

public class OAuth2Auth {

    public static String getOAuth2Token() {
        JsonObject jsObject = new JsonObject();
        jsObject.addProperty("client_id", "cmnGMnGPVKLJwWLfWxqFCSZOR5hIjhWb");
        jsObject.addProperty("client_secret", "uKCYJXAVkLY5gsWt");

        String tin = jsObject.toString();
        Response response = RestAssured
                .given()
                .body(jsObject.toString())
                .post("https://colsusbidio-test.apigee.net/oauth/client_credential/access_token")
                .then()
                .extract().response();

        String accessToken = response.jsonPath().getString("access_token");
        System.out.println("Access Token: " + accessToken);
        return accessToken;
    }
}
