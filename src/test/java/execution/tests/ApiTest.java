package execution.tests;


import execution.annotations.FrameworkAnnotation;
import execution.api.ReportUtils;
import execution.api.ServicesUtils;
import execution.api.TokenManager;
import execution.data.DataProviderUtil;
import execution.enums.CategoryType;
import io.restassured.response.Response;
import org.example.models.PreApprovedResponse;
import org.example.models.ValidationResponse;
import org.example.models.ValidatorRightsResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.ExtentLogger;
import utils.Constants;
import utils.baseTest.BaseRequest;

import static reports.ExtentManager.getExtentTest;

public class ApiTest extends BaseRequest {
    private SoftAssert softly;

    @BeforeTest()
    public void beforeTest() {
        softly = new SoftAssert();
    }


    @FrameworkAnnotation(authors = "Santiago Correa", testCategory = {CategoryType.SMOKE, CategoryType.REGRESSION}, userStory = "103023", testID = "10023")
    @Test(enabled = true, dataProvider = "fillDataApi", dataProviderClass = DataProviderUtil.class)
    public void testValidationServices(String typeDocument, String identification) {
        ExtentLogger.info("User: " + typeDocument + "-" + identification);

//        1)Local checks
        ExtentLogger.info("<b>Affiliate & Credentials</b>");
        boolean isAffiliate = ServicesUtils.isAffiliate(typeDocument, identification);
        if (isAffiliate)
            ExtentLogger.pass("✅User is affiliated and titular");
        else {
            ExtentLogger.fail("❌User is NOT affiliated or titular");
            softly.fail("Affiliate check failed");
        }

        boolean hasCredentialsSSO = TokenManager.hasCredentialsSSO(typeDocument, identification);
        if (hasCredentialsSSO)
            ExtentLogger.pass("✅User has SSO credentials");
        else {
            ExtentLogger.fail("❌User %s %s lacks SSO credentials".formatted(typeDocument, identification));
            softly.fail("SSO check failed");
        }
        ExtentLogger.infoJsonPretty(TokenManager.getAccessTokenSSOModel(typeDocument, identification));

//        3)Bizagi
//        Response response = ServicesUtils.validationBizagi(typeDocument, identification);
//        softly.assertEquals(response.getStatusCode(), 200, "The service Card Validations is failing");
//        ValidationResponse validationResponse = response.getStatusCode() == 200 ? response.as(ValidationResponse.class) : null;
//        ReportUtils.reportValidationBizagi(validationResponse, response);
//        ReportUtils.reportValidationBizagi(validationResponse, response);

//        2)Validator rights
        Response response = ServicesUtils.validatorRightsResponse(typeDocument, identification);
        softly.assertEquals(response.getStatusCode(), 200, "The service Validation Rights is failing");
        ValidatorRightsResponse validatorRightsResponse = response.getStatusCode() == 200 ? response.as(ValidatorRightsResponse.class) : null;
        ReportUtils.reportValidatorRights(validatorRightsResponse, identification, response);

//        3)Card validation
        response = ServicesUtils.validationCardsResponse(typeDocument, identification);
        softly.assertEquals(response.getStatusCode(), 200, "The service Card Validations is failing");
        ValidationResponse validationResponse = response.getStatusCode() == 200 ? response.as(ValidationResponse.class) : null;
        ReportUtils.reportValidationCards(validationResponse, response);

        // 4) Restrictive list
        response = ServicesUtils.validationListRestrictiveResponse(typeDocument, identification);
        softly.assertEquals(response.getStatusCode(), 200, "the service restrictive list is not working");
        validationResponse = response.getStatusCode() == 200 ? response.as(ValidationResponse.class) : null;
        ReportUtils.reportValidationListRestrictive(validationResponse, response);

        // 5) Siff validation
        response = ServicesUtils.validatorSiifResponse(typeDocument, identification);
        softly.assertEquals(response.getStatusCode(), 200, "the service restrictive list is not working");
        validationResponse = response.getStatusCode() == 200 ? response.as(ValidationResponse.class) : null;
        ReportUtils.reportValidationSiifValidation(validationResponse, response);

//         5) Preapproved
//        response = ServicesUtils.validationPreapprovedResponse(typeDocument, identification);
//        softly.assertEquals(response.getStatusCode(), 200, "Status should be 200");
//        PreApprovedResponse preApprovedResponse = response.getStatusCode() == 200 ? response.as(PreApprovedResponse.class) : null;
//        ReportUtils.reportPreapproved(preApprovedResponse, response);
//

        //Send the Asserts
        softly.assertAll();
    }
}

