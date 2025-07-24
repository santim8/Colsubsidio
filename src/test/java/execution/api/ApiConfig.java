package execution.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.http.ContentType.JSON;

public class ApiConfig {
    private static final String BASE_URL = "https://colsubsidio-test.apigee.net";
    private static final String OAUTH_TOKEN_URL = "/oauth/client_credential/accesstoken";
    private static final String CLIENT_ID = "cmnGMnGPVKLJwWLfWxqFCSZOR5hIjhWb";
    private static final String CLIENT_SECRET = "uKCYJXAVkLY5gsWt";

    public static String getAccessToken() {
        Response tokenResponse = RestAssured.given()
                .baseUri(BASE_URL)
                .queryParam("grant_type", "client_credentials")
                .auth()
                .basic(CLIENT_ID, CLIENT_SECRET)
                .log().all()
                .post(OAUTH_TOKEN_URL);

        if (tokenResponse.getStatusCode() != 200) {
            throw new RuntimeException("Failed to obtain OAuth token. Status code: " 
                    + tokenResponse.getStatusCode());
        }

        return tokenResponse.jsonPath().getString("access_token");
    }

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(JSON)
                .addHeader("Authorization", "Bearer " + getAccessToken())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static ResponseSpecification responseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void setup() {
        RestAssured.requestSpecification = requestSpec();
        RestAssured.responseSpecification = responseSpec();
    }
}