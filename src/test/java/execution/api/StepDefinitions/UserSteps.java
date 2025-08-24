package execution.api.StepDefinitions;

import execution.api.ServicesUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.ValidatorRightsResponse;
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


    @Given("The user is affiliate and titular")
    public void theUserIsAffiliateAndTitular() {
        boolean isAffiliate = ServicesUtils.isAffiliate("CC", "7277260");
        logger.info("validating the user is affiliate and titular");
        Assert.assertTrue(isAffiliate);
    }

    @Given("The User has credentials")
    public void theUserHasCredentials() {
        boolean isAffiliate = ServicesUtils.isAffiliate("CC", "7277260");
        logger.info("validating has credentials");
        Assert.assertTrue(isAffiliate);
    }

    @When("I GET request the preapproved response")
    public void iGetThePreapproved() {
        response = ServicesUtils.validationPreapprovedResponse("CC", "7277260");
        logger.info("validating credit preapproved");
    }

    @When("I POST request the validation card response")
    public void iPostTheValidationCard() {
        response = ServicesUtils.validationCardsResponse("CC", "7277260");
        logger.info("validating cards state");
    }

    @When("I Get request the validation rights response")
    public void iGetValidationRights() {
        response = ServicesUtils.validatorRightsResponse("CC", "7277260");
        validatorRightsResponse = response.as(ValidatorRightsResponse.class);
        logger.info("validating validation rights");
    }

    @When("I Get request the validation restrictive list response")
    public void iGetValidationRestrictiveList() {
        response = ServicesUtils.validatorRightsResponse("CC", "7277260");
        validatorRightsResponse = response.as(ValidatorRightsResponse.class);
        logger.info("validating validation rights");
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
        String birthIso  = dataList.get(0).getAfiliado().getFechaNacimiento();

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
}
