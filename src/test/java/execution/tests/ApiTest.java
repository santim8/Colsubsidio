package execution.tests;

import execution.api.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    static String baseUrl = "https://jsonplaceholder.typicode.com";

    @BeforeTest
    public void beforeTest() {
//        RestAssured.baseURI = baseUrl;
    }

//    @Test
//    public void testApi() {
//        RestAssured.baseURI  = "https://jsonplaceholder.typicode.com";
//        Response response = RestAssured.given()
//                .when()
//                .get("/albums")
//                .then()
//                .extract()
//                .response();
//
//        Integer code = response.getStatusCode();
//        Assert.assertEquals(code, 200);
//        System.out.println("Code: " + code);
//        System.out.println(response.getBody().prettyPrint());
//    }

    @Test(enabled = false)
    public void testPreapproroved() {
        RestAssured.baseURI = "https://platform-test-external.colsubsidio.com/loans/loans/external/v1/preapproved/CO1C";
        Response response = RestAssured.given()
                .get("/1023013504")
                .then()
                .extract()
                .response();

        Integer code = response.getStatusCode();
        Assert.assertEquals(code, 200);
        System.out.println("Code: " + code);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test(enabled = false)
    public void testValidatorRights() {
        Map<String, String> params = new HashMap<>();
        params.put("numeroId", "1024558557");
        params.put("tipoId", "CO1C");

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Authorization", "Bearer Xts3beWgins0jLATGAJeCcjH4nAh");


        RestAssured.baseURI = "https://colsubsidio-test.apigee.net/api/v2/afiliacion/validador";
        Response response = RestAssured.given()
                .headers(headers)
                .params(params)
                .log().all()
                .get("")
                .then()
                .extract()
                .response();

        Integer code = response.getStatusCode();
        Assert.assertEquals(code, 200);
        System.out.println("Code: " + code);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void testValidatorRightschat() {
        ApiConfig.setup();
        Map<String, String> params = new HashMap<>();
        params.put("numeroId", "1024558557");
        params.put("tipoId", "CO1C");

        Response response = RestAssured.given()
                .params(params)
                .get("/api/v2/afiliacion/validador")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getBody().prettyPrint());
    }
}

