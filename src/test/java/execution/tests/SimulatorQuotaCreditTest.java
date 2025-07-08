package execution.tests;

import execution.annotations.FrameworkAnnotation;
import execution.enums.CategoryType;
import execution.enums.EnumSimulatorQuota;
import execution.enums.EnumsRouteFlows;
import execution.listeners.RetryAnalyzer;
import execution.pages.pagesSimulatorQuotaCredit.SimulateQuotaFreeCredit;
import execution.pages.pagesSimulatorQuotaCredit.SimulatorQuotaCreditStep2;
import execution.pages.pagesSimulatorQuotaCredit.SimulatorQuotaCreditStep3;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.baseTest.BaseTest;


public class SimulatorQuotaCreditTest extends BaseTest {

    private SimulateQuotaFreeCredit simulateQuotaCredit;
    private SimulatorQuotaCreditStep2 simulatorFreeCreditStep2;
    private SimulatorQuotaCreditStep3 simulatorQuotaCreditStep3;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        simulateQuotaCredit = new SimulateQuotaFreeCredit(driver);
        simulatorFreeCreditStep2 = new SimulatorQuotaCreditStep2(driver);
        simulatorQuotaCreditStep3 = new SimulatorQuotaCreditStep3(driver);
        softAssert = new SoftAssert();
    }

    @FrameworkAnnotation(authors = "Santiago Correa", testCategory = {CategoryType.SMOKE, CategoryType.REGRESSION}, userStory = "103023", testID = "10023")
    @Test()
    @Parameters("path")
    public void testSimulatorQuotaCredit(String path) {
        simulateQuotaCredit
                .actionMessage(simulateQuotaCredit, "Opening the Simulator Quota Credit")
                .enterRegistrationNumber("1234567890")
                .markCheckboxTermsAndConditions()
                .actionMessage(simulateQuotaCredit, "Validating content screen");

        simulateQuotaCredit
                .validateDescription()
                .validateDocumentNumber()
                .validateTitle()
                .validateDocumentType()
                .takeScreenshot(simulateQuotaCredit, "Identification Screen")
                .clickNextButton();

        simulatorFreeCreditStep2
                .validateTitle()
                .enterAmount(EnumSimulatorQuota.AMOUNT_QUOTA.getValue())
                .validateAmountLabel()
                .validateQuantityLabel();

        if (path.equals(EnumsRouteFlows.OPTION_NUMBER_AMOUNT.getValue())) {
            simulatorFreeCreditStep2
                    .clickButtonValor()
                    .enterInputAmountQuota("1000000")
                    .clickNextButton();
        } else {
            simulatorFreeCreditStep2.enterQuantity(EnumSimulatorQuota.QUANTITY_QUOTA.getValue())
                    .clickNextButton();
        }

        simulatorQuotaCreditStep3
                .validateTitle()
                .clickOnMostrarDetails()
                .validatePurchaseValue()
                .takeScreenshot(simulatorQuotaCreditStep3, "Summary credit screen")
                .actionMessage(simulatorQuotaCreditStep3, "Validating the content summary credit")
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

        if (path.equals(EnumsRouteFlows.OPTION_NUMBER_NQUOTAS.getValue())) {
            softAssert.assertEquals(simulatorQuotaCreditStep3.validateDescription(), "Cuota Mensual");
        }

        softAssert.assertAll();
    }
}
