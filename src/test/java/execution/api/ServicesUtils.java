package execution.api;

import execution.core.enums.EnumDocumentTypeServices;
import io.restassured.response.Response;
import java.util.Map;
import static execution.api.TokenManager.getAccessToken;
import static io.restassured.RestAssured.baseURI;
import static utils.baseTest.BaseTestRequest.requestGet;
import static utils.baseTest.BaseTestRequest.requestPost;

public class ServicesUtils {

    private static final String baseApigee = "https://colsubsidio-test.apigee.net";
    private static final String basePlatformExt = "https://platform-test-external.colsubsidio.com";
    private static final String basePlatformInt = "https://platform-test-internal.colsubsidio.com";

    public ServicesUtils() {
    }

    public static boolean isAffiliate(String typeDocument, String identification) {
        baseURI = "https://platform-test-external.colsubsidio.com";
        Map<String, String> params = Map.of(
                "documentNumber", identification,
                "documentType", EnumDocumentTypeServices.getCode(typeDocument).getValue()
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

    public static Response validatorRightsResponse(String typeDocument, String identification) {
        String token = getAccessToken();
        Map<String, String> params = Map.of(
                "numeroId", identification,
                "tipoId", EnumDocumentTypeServices.getCode(typeDocument).getValue()
        );
        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token
        );

        return requestGet(baseApigee + "/api/v2/afiliacion/validador", headers, params);
    }

    public static Response validatorSiifResponse(String typeDocument, String identification) {
        String token = getAccessToken();
        String json = """
                {
                "idCaso": "a6d876f9c98d90",
                "documento": { "tipo": "%s", "numero": "%s" }}
                """.formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification);

        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token
        );

        return requestPost(baseApigee + "/api/v2/credito/elegibilidad/productos", headers, null, json);
    }

    public static Response validationCardsResponse(String typeDocument, String identification) {

        Map<String, String> headers = Map.of(
                "x-api-key", "rRXXnTUnej71MueSIqZdV91GgXe0tEIZ1kkV0B3h"
        );
        String json = """
                {"documento": { "tipo": "%s", "numero": "%s" }}
                """.formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification);

        return requestPost(basePlatformInt + "/loans/eligibility/external/v1/card-validations", headers, null, json);
    }

    public static Response validationListRestrictiveResponse(String typeDocument, String identification) {
        String token = getAccessToken();
        String body = """ 
                {
                "numeroDocumento" : "%s"
                ,"tipoDocumento": "%s"
                }
                """.formatted(identification, EnumDocumentTypeServices.getCode(typeDocument).getValue());

        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token
        );

        return requestPost(baseApigee + "/api/v2/credito/elegibilidad/listasrestrictivas", headers, null, body);
    }

    public static Response validationPreapprovedResponse(String typeDocument, String identification) {
        return requestGet(basePlatformExt + "/loans/loans/external/v1/preapproved/%s/%s".formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification), null, null);
    }

    public Response getOffers(String typeDocument, String identification) {
        Map<String, String> headers = Map.of(
                "Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQMTAzMDU5MzU5Nl8yIiwiY3VzdG9tZXIiOnsiZG9jdW1lbnROdW1iZXIiOiIxMDMwNTkzNTk2IiwiZG9jdW1lbnRUeXBlIjoiMiIsInRva2VuSWQiOiJBUUlDNXdNMkxZNFNmY3g3Ym5SczAycUpSMVZ6alNfNHJFVk01ZzZ4c2tXd0Y0WS4qQUFKVFNRQUNNREVBQWxOTEFCUXROekl6TWpVNE1USXdNVGcxT1RFNU56UTBOUS4uKiIsInRlbGVwaG9uZU51bWJlciI6Iis1NzMyMjM5ODQwOTYiLCJtYWlsIjoicHJ1ZWJhcmV0b21hOEBwb3dlcnNjcmV3cy5jb20iLCJ0aW1lU2Vzc2lvbiI6IjYwIiwidXNlcm5hbWUiOiJQMTAzMDU5MzU5Nl8yIiwiZmlyc3ROYW1lIjoiUHJ1ZWJhIiwibGFzdE5hbWUiOiJyZXQifSwiaWF0IjoxNzU1NjI0NDM0LCJleHAiOjE3NTU2MjgwMzR9.vXOBqYAmjUM_iXkdxCMgfp_exra2-DRVITa58Jvdg7y5aB-h5Xr3juPy_6YFRgfZ6vWaWAMKqCbNQCP9rfjQ9A",
                "accept", "application/json",
                "content-type", "application/json"
        );

        return requestGet("https://platform-test-external.colsubsidio.com/loans/loan-offer/external/v1/product/2/request/offer/177601", headers, null);
    }

    public static Response validationBizagi(String typeDocument, String identification) {
        Map<String, String> headers = Map.of(
                "x-api-key", "ecn24ysGnZ4X17cU5lX4Q9gyFvyPR7fD1DkwR7I7"
        );

        String json =
                """
                    {
                    "idCaso": "564789",
                    "documento": {
                        "tipo": "%s",
                        "numero": "%s"
                        }
                    }
                """.formatted(EnumDocumentTypeServices.getCode(typeDocument).getValue(), identification);

        return requestPost("https://platform-test-internal.colsubsidio.com/loans/eligibility/internal/v1/affiliation-validations", headers, null, json);
    }
}
