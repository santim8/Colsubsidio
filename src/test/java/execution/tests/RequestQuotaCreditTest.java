package execution.tests;


import execution.annotations.FrameworkAnnotation;
import execution.data.DataProviderUtil;
import execution.enums.CategoryType;
import execution.enums.EnumsDropdowns;
import execution.figma.FigmaImageManager;
import execution.figma.FigmaScreensData;
import execution.magnifie.MagnifaiMethods;
import execution.pages.pagesQuotaCredit.Login;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding1;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding2;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding3;
import execution.pages.pagesQuotaCredit.requestFlow.RequestCreditStep1;
import execution.pages.pagesSimulatorFreeCredit.SimulateFreeCreditPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ScreenshotUtils;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class RequestQuotaCreditTest extends BaseTest {

    private BasePage basePage;
    private Login login;
    private SolicitudCreditoOnboarding1 solicitudCreditoOnboarding1;
    private SolicitudCreditoOnboarding2 solicitudCreditoOnboarding2;
    private SolicitudCreditoOnboarding3 solicitudCreditoOnboarding3;
    private RequestCreditStep1 requestCreditStep1;
    private SimulateFreeCreditPage simulateFreeCreditPage;
    private static String FIGMAID = "MaMffi0VsnR9vSPsSHo3A9";
    private File figmaImage;

    @BeforeMethod
    private void setUp() throws Exception {
        basePage = new BasePage(driver);
        login = new Login(driver);
        solicitudCreditoOnboarding1 = new SolicitudCreditoOnboarding1(driver);
        solicitudCreditoOnboarding2 = new SolicitudCreditoOnboarding2(driver);
        solicitudCreditoOnboarding3 = new SolicitudCreditoOnboarding3(driver);
        requestCreditStep1 = new RequestCreditStep1(driver);
        simulateFreeCreditPage = new SimulateFreeCreditPage(driver);
    }

    @FrameworkAnnotation(authors = "Santiago Correa", testCategory = {CategoryType.SMOKE, CategoryType.REGRESSION}, userStory = "103023", testID = "10023")
    @Test(dataProvider = "fillTheCheckoutStepOne", dataProviderClass = DataProviderUtil.class, enabled = true)
    private void testMethod(
            String typeDocument,
            String identification,
            String password,
            String cellphoneNumber,
            String email
    ) throws IOException, InterruptedException {

        solicitudCreditoOnboarding1
                .setDimensionsScreen(solicitudCreditoOnboarding1, 1920, 1100)
                .actionMessage(solicitudCreditoOnboarding1, "Validating content Onboarding Step 1")
                .validateTitle()
                .takeScreenshotReport(solicitudCreditoOnboarding1, "Screen Onboarding Step 1")
                .clickNextButton();

        solicitudCreditoOnboarding2
                .actionMessage(solicitudCreditoOnboarding2, "Validating content Onboarding Step 2")
                .validateTitle()
                .takeScreenshotReport(solicitudCreditoOnboarding2, "Screen Onboarding Step 2")
                .clickNextButton();

        solicitudCreditoOnboarding3
                .actionMessage(solicitudCreditoOnboarding3, "Validating content Onboarding Step 1")
                .validateTitle()
                .takeScreenshotReport(solicitudCreditoOnboarding3, "Screen Onboarding Step 3")
                .clickStartButton()
                .takeScreenshotAndSaveItLocal(solicitudCreditoOnboarding3, "testNew");

        login
                .actionMessage(login, "The Login screen is open")
                .takeScreenshotAndSaveItLocal(login, "testNew")
                .enterIdentification(identification)
                .enterPassword(password)
                .takeScreenshotReport(login, "Login screen")
                .waitInteractionUser(login, "Please complete the login/CAPTCHA in browser.\nClick OK to continue automation.")
                .actionMessage(login, "The login is succesfully");


        File imageLogging = FigmaImageManager.getInstance().getImage(FigmaScreensData.SCREEN1.getKey());
        MagnifaiMethods.flexCompare(ScreenshotUtils.getScreenshotFile("testNew"), imageLogging, new BigDecimal("80"), "validating figma comparison");
/*
        simulateFreeCreditPage
                .markCheckboxTermsAndConditions()
                .clickOnContinueButton();
*/

        requestCreditStep1
                .actionMessage(requestCreditStep1, "The form is open")
                .enterPhoneNumber(cellphoneNumber)
                .enterEmail(email)
                .enterConfirmationEmail(email)
                .takeScreenshotReport(requestCreditStep1, "Request Credit Form 1")
                .clickNextButton()
                .openMaritalStatusDropdown()
                .selectOptionMaritalStatus(EnumsDropdowns.SOLTERO.getValue())
                .openEducationLevelDropdown()
                .selectOptionEducationLevel(EnumsDropdowns.PRIMARIA.getValue())
                .takeScreenshotReport(requestCreditStep1, "Request Credit Form 2")
                .clickNextButton()
                .selectOptionHousingTypeLabel()
                .clickNextButton()
                .selectOptionObraLabor()
                .takeScreenshotReport(requestCreditStep1, "Request Credit Form 3")
                .clickNextButton()
                .enterMonthlyIncome("100000000")
                .takeScreenshotReport(requestCreditStep1, "Request Credit Form 1");
    }
}