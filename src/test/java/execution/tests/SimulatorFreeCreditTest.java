package execution.tests;

import execution.annotations.FrameworkAnnotation;
import execution.enums.CategoryType;
import execution.enums.EnumSimulatorQuota;
import execution.pages.pagesSimulatorFreeCredit.SimulateFreeCreditPage;
import execution.pages.pagesSimulatorFreeCredit.SimulatorFreeCreditStep2;
import execution.pages.pagesSimulatorFreeCredit.SimulatorFreeCreditStep3;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;

public class SimulatorFreeCreditTest extends BaseTest {
    private SimulateFreeCreditPage simulateFreeCreditPage;
    private SimulatorFreeCreditStep2 simulatorFreeCreditStep2;
    private SimulatorFreeCreditStep3 simulatorFreeCreditStep3;
    private SoftAssert softAssert;
    private BasePage basePage;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        basePage = new BasePage(driver);
        simulateFreeCreditPage = new SimulateFreeCreditPage(driver);
        simulatorFreeCreditStep2 = new SimulatorFreeCreditStep2(driver);
        simulatorFreeCreditStep3 = new SimulatorFreeCreditStep3(driver);
    }

    @FrameworkAnnotation(authors = "Santiago Correa", testCategory = {CategoryType.SMOKE, CategoryType.REGRESSION}, userStory = "103023", testID = "10023")
    @Test
    public void testSimulator(ITestContext iTestContext) {

        simulateFreeCreditPage
                .enterRegistrationNumber("79278366")
                .markCheckboxTermsAndConditions()
                .takeScreenshotReport(simulateFreeCreditPage, "Initial screen")
                .clickOnContinueButton();

        simulatorFreeCreditStep2
                .enterQuantity("7")
                .enterAmount("10000000")
                .validateTitle()
                .validateAmountLabel()
                .validateQuantityLabel()
                .takeScreenshotReport(simulatorFreeCreditStep2, "Second form screen")
                .clickNextButton();

        simulatorFreeCreditStep3
                .validateTitle()
                .clickOnMostrarDetails()
                .takeScreenshotReport(simulatorFreeCreditStep3, "Summary credit screen")
                .actionMessage(simulatorFreeCreditStep3, "Validating the content summary credit")
                .validateDescription()
                .validateSummaryText()
                .validateNumberQuote()
                .clickModalAnnualRate()
                .validateModalAnnualRate()
                .clickButtonUnderstood()
                .clickModalNominalRate()
                .clickButtonUnderstood()
                .clickModalInsurance()
                .validateModalInsurance()
                .clickButtonUnderstood();

        softAssert.assertEquals(simulatorFreeCreditStep3.getPercentageElement(), EnumSimulatorQuota.TASA_EFECTIVA_ANUAL.getValue());
        softAssert.assertEquals(simulatorFreeCreditStep3.getPercentageElementTasaNominal(), EnumSimulatorQuota.TASA_NOMINAL_MV.getValue());
        softAssert.assertAll();
    }
}
