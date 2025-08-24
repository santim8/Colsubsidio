package utils;

public class Constants {

    public static final  String VALUE_CONTENT_TYPE       = "application/json";
    public static final  String CONTENT_TYPE             = "Content-Type";
    public static final  String CLIENTS_PATH             = "clients";
    public static final String RESOURCE_PATH            = "resources";
    public static final  String DEFAULT_CLIENT_FILE_PATH = "src/main/resources/data/defaultClient.json";
    public static final  String DEFAULT_RESOURCE_FILE_PATH = "src/main/resources/data/defaultResource.json";
    public static final String BASE_URL                 = "https://63b6dfe11907f863aa04ff81.mockapi.io";
    public static final  String URL                      = "/api/v1/%s";
    public static final  String URL_WITH_PARAM           = "/api/v1/%s/%s";
    public static final String baseApigee = "https://colsubsidio-test.apigee.net";
    public static final String basePlatformInt = "https://platform-test-internal.colsubsidio.com";
    public static final String basePlatformExt = "https://platform-test-external.colsubsidio.com";
    public static final String validationPreapproved = "https://platform-test-external.colsubsidio.com/loans/loans/external/v1/preapproved";
    public static final String validatorRights = "https://colsubsidio-test.apigee.net/api/v2/afiliacion/validador";
    public static final String validationListRestrictive = "https://colsubsidio-test.apigee.net/api/v2/credito/elegibilidad/listasrestrictivas";
    public static final String validationCards = "https://platform-test-internal.colsubsidio.com/loans/eligibility/external/v1/card-validations";
    public static final String RETIRED = "RETIR";
    public static final String ACTIVE = "VIGEN";
    public static final String VALIDATION_ERROR = "VALIDATION_ERROR";
    public static final String OK = "OK";
    public static final String CARD_STATUS = "CARD_STATUS";

    private Constants() {
    }
}
