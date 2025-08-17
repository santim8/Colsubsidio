package org.example.requests;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ClientRequest {

    private ClientRequest() {
    }

    public static boolean validateRequest(Response response, String route) {
        try {
            response
                    .then()
                    .assertThat()
                    .body(
                           JsonSchemaValidator.matchesJsonSchemaInClasspath(route)
                    );
            return true;
        } catch (AssertionError e){
            return false;
        }
    }
}
