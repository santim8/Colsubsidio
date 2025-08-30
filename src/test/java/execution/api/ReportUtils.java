package execution.api;

import io.restassured.response.Response;
import org.example.models.PreApprovedResponse;
import org.example.models.ValidationResponse;
import org.example.models.ValidatorRightsResponse;
import reports.ExtentLogger;
import utils.Constants;

import static reports.ExtentManager.getExtentTest;

public class ReportUtils {
    public static void reportPreapproved(PreApprovedResponse preApprovedResponse, Response response) {
        ExtentLogger.info("<b>Preapproved Credit</b>");
        if (getExtentTest() != null) {
            if (response.getStatusCode() == 200) {
                ExtentLogger.pass("the service preapproved is working correctly url: " + Constants.validationPreapproved);
                if (preApprovedResponse.getData().isHasCredit()) {
                    ExtentLogger.pass("✅The user has PREAPPROVED");
                } else {
                    ExtentLogger.fail("❌The user has NOT PREAPPROVED");
                }
            } else {
                ExtentLogger.fail("The service <b>Preapproved</b> is not working url:" + Constants.validationPreapproved);
            }
            ExtentLogger.infoJsonPretty(preApprovedResponse.getData());
        }
    }

    public static void reportValidatorRights(ValidatorRightsResponse validatorRightsResponse, String identification, Response response) {

        ExtentLogger.info("<b>Validator Rights</b>");
        if (getExtentTest() != null) {
            if (response.getStatusCode() != 200) {
                ExtentLogger.fail("the service <b>Validation rights</b> is failing status: " + response.getStatusCode() + "url : " + Constants.validatorRights);
                ExtentLogger.info("Response" + (response.jsonPath().get()));
                return;
            }
            if (validatorRightsResponse.getEstado() == 200) {
                ExtentLogger.pass("The service validate rights is working url: " + Constants.validatorRights);
                if (!validatorRightsResponse.getData().isEmpty()) {
                    if (validatorRightsResponse.getData().get(0).getAfiliado().getEstado().equals("RETIR")) {
                        ExtentLogger.fail("❌the user is RETIRED");
                    } else if (validatorRightsResponse.getData().get(0).getAfiliado().getEstado().equals("VIGEN")) {
                        ExtentLogger.pass("✅The user is ViGENT");
                    }
                    if (validatorRightsResponse.getData().get(0).getAfiliado().getNumeroDocumento().equals(identification)) {
                        ExtentLogger.pass("✅The user is TITULAR");
                    } else {
                        ExtentLogger.fail("❌The user is NOT TITULAR");
                    }
                } else {
                    ExtentLogger.fail("❌The user is NOT affiliate");
                }
            } else {
                ExtentLogger.fail("The service fail validating the url: " + Constants.validatorRights);
            }
            ExtentLogger.infoJsonPretty(validatorRightsResponse.getData());
        }
    }

    public static void reportValidationCards(ValidationResponse validationResponse, Response response) {
        ExtentLogger.info("<b>Card Validations</b>");
        if (getExtentTest() != null) {
            if (response.getStatusCode() != 200) {
                ExtentLogger.fail("the service <b>Cards Validations</b> is failing status: " + response.getStatusCode() + " url: " + Constants.validationCards);
                ExtentLogger.info("Response" + (response.jsonPath().get()));
                return;
            }
            if (validationResponse.getResultado().get(0).getCodigo() == 200) {
                ExtentLogger.pass("The service validate rights is working url: " + Constants.validationCards);
                String state = validationResponse.getResultadoValidacion().getEstado();
                if (state.equals("OK")) {
                    ExtentLogger.pass("✅The user pass the ASKARD validations");
                } else if (state.equals("VALIDATION_ERROR")) {
                    ExtentLogger.fail("❌The user NOT pass the ASKARD validations");
                    String codeValidation = validationResponse.getResultadoValidacion().getDatosError().getCodigoErrorValidacion();
                    if (codeValidation.equals("CARD_STATUS")) {
                        ExtentLogger.fail("❌The user has not CARD");
                    } else if (codeValidation.equals("INVALID_REQUIREMENTS")) {
                        ExtentLogger.fail("❌The user has a active CARD with some state or amparada");
                    }
                } else {
                    ExtentLogger.info("the state is not recognized");
                }
                ExtentLogger.infoJsonPretty(validationResponse.getResultadoValidacion());
            } else {
                ExtentLogger.pass("❌The service validate rights is NOT working url: " + Constants.validationCards);
            }
        }
    }

    public static void reportValidationListRestrictive(ValidationResponse validationResponse, Response response) {
        ExtentLogger.info("<b>Restrictive List</b>");
        if (getExtentTest() != null) {
            if (response.getStatusCode() != 200) {
                ExtentLogger.fail("the service <b>Restrictive List</b> is failing status: " + response.getStatusCode() + " url: " + Constants.validationListRestrictive);
                ExtentLogger.info("Response: " + response.jsonPath().get());
                return;
            }
            if (validationResponse.getResultado().get(0).getCodigo() == 200) {
                ExtentLogger.pass("The service restrictive list is working url: " + Constants.validationListRestrictive);
                String state = validationResponse.getResultadoValidacion().getEstado();
                if (state.equals("OK")) {
                    ExtentLogger.pass("✅The user pass the LIST RESTRICTIVE validations");
                } else if (state.equals("VALIDATION_ERROR")) {
                    ExtentLogger.fail("❌The user DOES NOT pass LIST RESTRICTIVE validations");
                } else {
                    ExtentLogger.info("❌the state is not recognized");
                }
                ExtentLogger.infoJsonPretty(validationResponse.getResultadoValidacion());
            }
        }
    }

    public static void reportValidationBizagi(ValidationResponse validationResponse, Response response) {
        ExtentLogger.info("<b>Validation Bizagi</b>");
        if (getExtentTest() != null) {
            if (response.getStatusCode() != 200) {
                ExtentLogger.fail("the service <b>Validation Bizagi</b> is failing status: " + response.getStatusCode() + " url: " + Constants.validationListRestrictive);
                ExtentLogger.info("Response: " + response.jsonPath().get());
                return;
            }
            if (validationResponse.getResultado().get(0).getCodigo() == 200) {
                ExtentLogger.pass("The service Validation Bizagi is working url: " + Constants.validationBizagi);
                String state = validationResponse.getResultadoValidacion().getEstado();
                if (state.equals("OK")) {
                    ExtentLogger.pass("✅The user pass the Validation Bizagi validations");
                } else if (state.equals("VALIDATION_ERROR")) {
                    ExtentLogger.fail("❌The user DOES NOT pass Validation Bizagi validations");
                } else {
                    ExtentLogger.info("❌the state is not recognized");
                }
                ExtentLogger.infoJsonPretty(validationResponse.getResultadoValidacion());
            }
        }
    }
}
