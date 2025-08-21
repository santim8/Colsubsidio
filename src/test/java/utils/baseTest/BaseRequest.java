package utils.baseTest;

import io.restassured.response.Response;
import utils.Constants;
import java.util.Collections;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseRequest {


    public static Response requestGet(String endpoint, Map<String, ?> headers, Map<String, ?> params) {

        return given()
                .headers(headers != null ? headers : Collections.emptyMap())
                .params(params != null ? params : Collections.emptyMap())
                .contentType(Constants.VALUE_CONTENT_TYPE)
                .accept(Constants.VALUE_CONTENT_TYPE)
                .when()
                .get(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static Response requestPost(String endpoint, Map<String, ?> headers, Map<String, ?> params, String body) {

        return given()
                .headers(headers != null ? headers : Collections.emptyMap())
                .params(params != null ? params : Collections.emptyMap())
                .contentType(Constants.VALUE_CONTENT_TYPE)
                .body(body)
                .accept(Constants.VALUE_CONTENT_TYPE)
                .post(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public BaseRequest() {
    }
}
