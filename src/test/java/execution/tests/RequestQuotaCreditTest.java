package execution.tests;


import execution.data.DataProviderUtil;
import execution.enums.EnumsDropdowns;
import execution.pages.pagesQuotaCredit.Login;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding1;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding2;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding3;
import execution.pages.pagesQuotaCredit.requestFlow.RequestCreditStep1;
import execution.pages.pagesSimulatorFreeCredit.SimulateFreeCreditPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;


public class RequestQuotaCreditTest extends BaseTest {

    private BasePage basePage;
    private Login login;
    private SolicitudCreditoOnboarding1 solicitudCreditoOnboarding1;
    private SolicitudCreditoOnboarding2 solicitudCreditoOnboarding2;
    private SolicitudCreditoOnboarding3 solicitudCreditoOnboarding3;
    private RequestCreditStep1 requestCreditStep1;
    private SimulateFreeCreditPage simulateFreeCreditPage;

    @BeforeClass()
    private void setUpReport() {

        ExtentReport.initReports();
    }

    @BeforeMethod
    private void setUp() {
        basePage = new BasePage(driver);
        login = new Login(driver);
        solicitudCreditoOnboarding1 = new SolicitudCreditoOnboarding1(driver);
        solicitudCreditoOnboarding2 = new SolicitudCreditoOnboarding2(driver);
        solicitudCreditoOnboarding3 = new SolicitudCreditoOnboarding3(driver);
        requestCreditStep1 = new RequestCreditStep1(driver);
        simulateFreeCreditPage = new SimulateFreeCreditPage(driver);
    }


    @Test(dataProvider = "fillTheCheckoutStepOne", dataProviderClass = DataProviderUtil.class)
    private void testMethod(
            String identification,
            String password,
            String cellphoneNumber,
            String email,
            String testName
    ) {
        ExtentReport.createTest(testName + " identification  = " + identification);

        basePage
                .actionMessage(basePage, "Opening the application: Solicitud Colsubsidio")
                .clickDetailsButton()
                .clickProceedLink();

        solicitudCreditoOnboarding1
                .actionMessage(solicitudCreditoOnboarding1, "Validating content Onboarding Step 1")
                .validateTitle()
                .takeScreenshot(solicitudCreditoOnboarding1, "Screen Onboarding Step 1")
                .clickNextButton();

        solicitudCreditoOnboarding2
                .actionMessage(solicitudCreditoOnboarding2, "Validating content Onboarding Step 2")
                .validateTitle()
                .takeScreenshot(solicitudCreditoOnboarding2, "Screen Onboarding Step 2")
                .clickNextButton();

        solicitudCreditoOnboarding3
                .actionMessage(solicitudCreditoOnboarding3, "Validating content Onboarding Step 1")
                .validateTitle()
                .takeScreenshot(solicitudCreditoOnboarding3, "Screen Onboarding Step 3")
                .clickStartButton();

        login
                .actionMessage(login, "The Login screen is open")
                .enterIdentification(identification)
                .enterPassword(password)
                .takeScreenshot(login, "Login screen")
                .waitInteractionUser(login, "Please complete the login/CAPTCHA in browser.\nClick OK to continue automation.")
                .actionMessage(login,"The login is succesfully");

/*
        simulateFreeCreditPage
                .markCheckboxTermsAndConditions()
                .clickOnContinueButton();
*/

        requestCreditStep1
                .actionMessage(requestCreditStep1,"The form is open")
                .enterPhoneNumber(cellphoneNumber)
                .enterEmail(email)
                .enterConfirmationEmail(email)
                .takeScreenshot(requestCreditStep1, "Request Credit Form 1")
                .clickNextButton()
                .openMaritalStatusDropdown()
                .selectOptionMaritalStatus(EnumsDropdowns.SOLTERO.getValue())
                .openEducationLevelDropdown()
                .selectOptionEducationLevel(EnumsDropdowns.PRIMARIA.getValue())
                .takeScreenshot(requestCreditStep1, "Request Credit Form 2")
                .clickNextButton()
                .validateHousingTypeLabel()
                .selectOptionTipoHousingTypeLabel()
                .clickNextButton()
                .selectOptionObraLabor()
                .takeScreenshot(requestCreditStep1, "Request Credit Form 3")
                .clickNextButton()
                .enterMonthlyIncome("100000000")
                .takeScreenshot(requestCreditStep1, "Request Credit Form 1");
    }

    @AfterClass()
    private void tearDown() {
        ExtentReport.flushReports();
    }
}
