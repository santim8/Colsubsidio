package execution.api;

import io.restassured.response.Response;

import java.util.Map;

import static utils.baseTest.BaseRequest.requestGet;
import static utils.baseTest.BaseRequest.requestPost;

public final class ColsubsidioClient {
    private final String baseApigee;
    private final String basePlatformExt;
    private final String basePlatformInt;
    private final String apiKey;
    private final String token;

    public ColsubsidioClient(String baseApigee, String basePlatformExt, String basePlatformInt, String apiKey, String token) {
        this.baseApigee = baseApigee;
        this.basePlatformExt = basePlatformExt;
        this.basePlatformInt = basePlatformInt;
        this.apiKey = apiKey;
        this.token = token;
    }

    public Response getValidatorRights(String tipoId, String numeroId) {
        Map<String, String> headers = Map.of(
                "accept", "application/json",
                "Authorization", "Bearer " + token
        );
        Map<String, String> params = Map.of("numeroId", numeroId, "tipoId", tipoId);
        return requestGet(baseApigee + "/api/v2/afiliacion/validador", headers, params);
    }

    public Response postCardValidations(String tipo, String numero) {
        Map<String, String> headers = Map.of("x-api-key", apiKey, "accept", "application/json", "content-type", "application/json");
        String json = """
        {
          "documento": { "tipo": "%s", "numero": "%s" }
        }
        """.formatted(tipo, numero);
        return requestPost(basePlatformInt + "/loans/eligibility/external/v1/card-validations", headers, null, json);
    }

    public Response postRestrictiveList(String tipo, String numero) {
        Map<String, String> headers = Map.of(
                "Authorization", "Bearer " + token,
                "accept", "application/json",
                "content-type", "application/json"
        );
        String body = """
        { "numeroDocumento": "%s", "tipoDocumento": "%s" }
        """.formatted(numero, tipo);
        return requestPost(baseApigee + "/api/v2/credito/elegibilidad/listasrestrictivas", headers, null, body);
    }

    public Response getPreapproved(String tipo, String numero) {
        return requestGet(basePlatformExt + "/loans/loans/external/v1/preapproved/%s/%s".formatted(tipo, numero), Map.of(), null);
    }

    // TODO: your existing requestGet / requestPost implementations + timeouts/retries
}