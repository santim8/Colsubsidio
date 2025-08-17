package execution.tests;


import execution.data.DataProviderUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.requests.ClientRequest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reports.ExtentLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static execution.api.ApiConfig.getAccessToken;
import static io.restassured.RestAssured.*;
import static reports.ExtentManager.getExtentTest;

public class ApiTest {

    @BeforeTest()
    public void beforeTest() {
//        RestAssured.baseURI = baseUrl;
    }


    @Test(enabled = false, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class, priority = 1)
    public void testPreapproved(
            String typeDocument,
            String identification
    ) {
        boolean hasCredit = false;
        List listCredits = new ArrayList();

        RestAssured.baseURI = "https://platform-test-external.colsubsidio.com";
        Response response = given()
                .log()
                .uri()
                .get("/loans/loans/external/v1/preapproved/CO1C/" + identification)
                .then()
                .log()
                .all()
                .extract()
                .response();

        ClientRequest.validateRequest(response, "src/test/resources/src/test/resources/schemas/validator_rights_schema.json");

        Integer code = response.getStatusCode();
//        Assert.assertEquals(code, 200);
        if (code.equals(200)) {
            hasCredit = response.jsonPath().getBoolean("data.hasCredit");
            listCredits = response.jsonPath().getList("data.credits");
        }
        if (getExtentTest() != null) {
            if (code.equals(200)) {
                ExtentLogger.pass("The service preapproved is working correctly");
                if (hasCredit) {
                    ExtentLogger.info("The user " + typeDocument + " " + identification + " has preapproved");
                    ExtentLogger.info("lista: " + listCredits);
                } else {
                    ExtentLogger.fail("The user " + typeDocument + " " + identification + " has NOT preapproved");
                }
            } else {
                ExtentLogger.fail("The service preapproved is NOT working correctly");
            }
        }
    }

    @Test(enabled = true, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class)
    public void testValidatorRights(
            String typeDocument,
            String identification
    ) {
        String token = getAccessToken();
        Map<String, String> params = new HashMap<>();
        params.put("numeroId", identification);
        params.put("tipoId", "CO1C");

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Authorization", "Bearer " + token);

        RestAssured.baseURI = "https://colsubsidio-test.apigee.net";
        Response response = given()
                .headers(headers)
                .params(params)
                .log().all()
                .get("/api/v2/afiliacion/validador")
                .then()
                .log().all()
                .extract()
                .response();

        boolean tin = ClientRequest.validateRequest(response, "schemas/validator_rights_schema.json");

        String text = response.jsonPath().getString("");
        Integer code = response.getStatusCode();

        if (getExtentTest() != null) {
            if (code == 200) {
                ExtentLogger.pass("The service <b>validate rights</b> is working");
                ExtentLogger.info("The response is: "+ text);
            } else {
                ExtentLogger.fail("The service  <b>validate rights</b> is working");
            }
        }
    }

    @Test(enabled = false, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class, priority = 2)
    public void testValidateRequest(
            String typeDocument,
            String identification
    ) {
        baseURI = "https://platform-test-external.colsubsidio.com";
        Map<String, String> params = new HashMap<>();
        params.put("documentNumber", identification);
        params.put("documentType", "CO1C");

        Response response = given()
                .log()
                .all()
                .params(params)
                .get("loans/clients/external/v1/validate-holder")
                .then()
                .log()
                .all()
                .extract()
                .response();

        var body = response.jsonPath();
        Integer status = response.getStatusCode();
        System.out.println("tin status: " + status);

        if (getExtentTest() != null) {
            ExtentLogger.pass("The service validate-holder is validating the user");
            if (status.equals(200)) {
                ExtentLogger.info("The user " + typeDocument + " " + identification + " is a registered affiliate");
            } else {
                ExtentLogger.fail("The user " + typeDocument + " " + identification + " is NOT a registered affiliate");
            }
        }
    }

    @Test(enabled = false, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class, priority = 3)
    public void testRedebanStates(
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

        Response response = given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(json)
                .post("/loans/eligibility/external/v1/card-validations")
                .then()
                .log()
                .all()
                .extract()
                .response();

        var body = response.jsonPath();
        Integer status = response.getStatusCode();
        String state = response.jsonPath().getString("resultadoValidacion.estado");
        String errorData = response.jsonPath().getString("resultadoValidacion.datosError");
        String dataNotProcess = response.jsonPath().getString("resultadoValidacion.datosSinProcesar");

        if (getExtentTest() != null) {
            ExtentLogger.pass("The service redeban states is validating the user");
            if (status.equals(200)) {
                if (state.equals("OK")) {
                    ExtentLogger.pass("The user " + typeDocument + " " + identification + " pass the ASKARD validations");
                } else {
                    ExtentLogger.fail("The user " + typeDocument + " " + identification + " NOT pass the ASKARD validations");
                    ExtentLogger.info("Datos error : " + errorData);
                    ExtentLogger.info("Datos sin procesar : " + dataNotProcess);
                }
            } else {
                ExtentLogger.fail("The user " + typeDocument + " " + identification + " is NOT a registered affiliate");
            }
        }
    }

    @Test(enabled = false, dataProviderClass = DataProviderUtil.class, dataProvider = "fillDataApi", priority = 4)
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

        Response response = given()
                .headers(headers)
                .body(body)
                .log()
                .all()
                .when()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .response();

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
}

