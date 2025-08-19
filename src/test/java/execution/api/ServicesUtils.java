package execution.api;

import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.baseURI;
import static utils.baseTest.BaseRequest.requestGet;

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
}
