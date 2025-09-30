package execution.api.StepDefinitions;

import execution.api.ServicesUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.colsubsidio.framework.models.PreApprovedResponse;
import org.colsubsidio.framework.models.ValidationResponse;
import org.colsubsidio.framework.models.ValidatorRightsResponse;
import org.junit.Assert;
import utils.Constants;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.List;

public class UserSteps {

    private static final Logger logger = LogManager.getLogger(UserSteps.class);
    private Response response;
    private ValidatorRightsResponse validatorRightsResponse;
    private final int MIN_ADULT_YEARS = 18;
    private ValidationResponse validationResponse;
    private String docType;
    private String docNumber;
    private PreApprovedResponse preApprovedResponse;

    @Given("The user is affiliate and titular")
    public void theUserIsAffiliateAndTitular() {
        boolean isAffiliate = ServicesUtils.isAffiliate(docType, "7277260");
        logger.info("validating the user is affiliate and titular");
        Assert.assertTrue(isAffiliate);
    }

    @Given("a user with docType {string} and docNumber {string}")
    public void aUserWithDocTypeAndDocNumber(String docType, String docNumber) {
        this.docType = docType;
        this.docNumber = docNumber;
        logger.info("Using user docType: " + docType + " and " + "identification: " + docNumber);
    }

    @Given("The User has credentials")
    public void theUserHasCredentials() {
        boolean isAffiliate = ServicesUtils.isAffiliate(docType, docNumber);
        logger.info("validating has credentials");
        Assert.assertTrue(isAffiliate);
    }

    @When("I GET request the preapproved response")
    public void iGetThePreapproved() {
        response = ServicesUtils.validationPreapprovedResponse(docType, docNumber);
        logger.info("validating credit preapproved");
    }

    @When("I POST request the validation card response")
    public void iPostTheValidationCard() {
        response = ServicesUtils.validationCardsResponse(docType, docNumber);
        validationResponse = response.as(ValidationResponse.class);
        logger.info("validating cards state");
    }

    @When("I Get request the validation rights response")
    public void iGetValidationRights() {
        response = ServicesUtils.validatorRightsResponse(docType, docNumber);
        validatorRightsResponse = response.as(ValidatorRightsResponse.class);
        logger.info("validating validation rights");
    }

    @When("I POST request the validation restrictive list response")
    public void iPostValidationRestrictiveList() {
        logger.info("validating user in restrictive list");
        response = ServicesUtils.validationListRestrictiveResponse("CC", docNumber);
        validationResponse = response.as(ValidationResponse.class);
    }


    @Then("The response should have a status code of {int}")
    public void theResponseShouldHaveAStatusCodeOf(int statusCode) {
        logger.info("the response should have a status code of " + statusCode);
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @Then("The User is adult")
    public void theUserIsAdult() {

        logger.info("validating the user is active");
        List<ValidatorRightsResponse.DataItem> dataList = validatorRightsResponse.getData();
        if (dataList == null || dataList.isEmpty()) {
            logger.error("Validation failed: data is null or empty in validatorRightsResponse");
            Assert.fail("No data found in validatorRightsResponse");
        }
        String birthIso = dataList.get(0).getAfiliado().getFechaNacimiento();

        final LocalDate birthDate;
        try {
            birthDate = OffsetDateTime.parse(birthIso).toLocalDate();
        } catch (DateTimeParseException ex) {
            logger.error("Failed to parse birth date '{}': {}", birthIso, ex.getMessage());
            Assert.fail("Invalid birth date format: " + birthIso);
            return;
        }
        LocalDate todayUtc = LocalDate.now(ZoneOffset.UTC);
        int years = Period.between(LocalDate.parse(birthIso), todayUtc).getYears();

        logger.info("Computed age: {} (birthDate={}, todayUTC={})", years, LocalDate.parse(birthIso), todayUtc);

        Assert.assertTrue(
                String.format("User is not adult. Expected >= %d, got %d", MIN_ADULT_YEARS, years),
                years >= MIN_ADULT_YEARS
        );
    }

    @Then("The User is active")
    public void theUserIsActive() {
        logger.info("validating the user is active");
        List<ValidatorRightsResponse.DataItem> dataList = validatorRightsResponse.getData();
        if (dataList == null || dataList.isEmpty()) {
            logger.error("Validation failed: data is null or empty in validatorRightsResponse");
            Assert.fail("No data found in validatorRightsResponse");
        }
        String state = dataList.get(0).getAfiliado().getEstado();
        logger.info("validating the user is active");
        Assert.assertEquals(Constants.RETIRED, state);
    }

    @Then("The User pass restrictive validation")
    public void theUserPassRestrictiveValidation() {
        logger.info("validating the user pass the restrictive validation");
        ValidationResponse.ResultadoValidacion resultadoValidacion = validationResponse.getResultadoValidacion();
        if (resultadoValidacion == null) {
            logger.error("Validation failed: data is null or empty in validatorRightsResponse");
            Assert.fail("No data found in validatorRightsResponse");
        }
        Assert.assertEquals(Constants.OK, resultadoValidacion.getEstado());
    }

    @Then("The User pass preapproved validation")
    public void theUserPassPreapprovedValidation() {
        logger.info("validating the user pass the preapproved");
        PreApprovedResponse.DataBlock dataBlock = preApprovedResponse.getData();
        if (dataBlock == null) {
            logger.error("Validation failed: data is null or empty in validatorRightsResponse");
            Assert.fail("No data found in validatorRightsResponse");
        }
        Assert.assertTrue(dataBlock.isHasCredit());
    }
}
