package execution.tests;


import com.globant.aut.sdk.builder.MagnifAI;
import com.globant.aut.sdk.figma.Figma;
import execution.annotations.FrameworkAnnotation;
import execution.data.DataProviderUtil;
import execution.enums.CategoryType;
import execution.magnifie.MagnifaiManager;
import execution.magnifie.MagnifaiMethods;
import execution.pages.pagesQuotaCredit.Login;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding1;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding2;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding3;
import execution.pages.pagesQuotaCredit.requestFlow.RequestCreditStep1;
import execution.pages.pagesSimulatorFreeCredit.SimulateFreeCreditPage;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ScreenshotUtils;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;


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
    private void setUp() {
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
//        basePage
//                .actionMessage(basePage, "Opening the application: Solicitud Colsubsidio");
//                .clickDetailsButton()
//                .clickProceedLink();
//

        solicitudCreditoOnboarding1
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
                .setDimensionsScreen(solicitudCreditoOnboarding3, 1920, 1100)
                .takeScreenshotAndSaveItLocal(solicitudCreditoOnboarding3, "santiago.png");


        File Route = ScreenshotUtils.getScreenshotFile("santiago.png");
//        MagnifaiMethods.flexCompare(Route, null, new BigDecimal("80"), "tin flex santigo");



//
//
//        login
//                .actionMessage(login, "The Login screen is open")
//                .enterIdentification(identification)
//                .enterPassword(password)
//                .takeScreenshot(login, "Login screen")
//                .waitInteractionUser(login, "Please complete the login/CAPTCHA in browser.\nClick OK to continue automation.")
//                .actionMessage(login, "The login is succesfully");

/*
        simulateFreeCreditPage
                .markCheckboxTermsAndConditions()
                .clickOnContinueButton();
*/

//        requestCreditStep1
//                .actionMessage(requestCreditStep1, "The form is open")
//                .enterPhoneNumber(cellphoneNumber)
//                .enterEmail(email)
//                .enterConfirmationEmail(email)
//                .takeScreenshot(requestCreditStep1, "Request Credit Form 1")
//                .clickNextButton()
//                .openMaritalStatusDropdown()
//                .selectOptionMaritalStatus(EnumsDropdowns.SOLTERO.getValue())
//                .openEducationLevelDropdown()
//                .selectOptionEducationLevel(EnumsDropdowns.PRIMARIA.getValue())
//                .takeScreenshot(requestCreditStep1, "Request Credit Form 2")
//                .clickNextButton()
//                .selectOptionHousingTypeLabel()
//                .clickNextButton()
//                .selectOptionObraLabor()
//                .takeScreenshot(requestCreditStep1, "Request Credit Form 3")
//                .clickNextButton()
//                .enterMonthlyIncome("100000000")
//                .takeScreenshot(requestCreditStep1, "Request Credit Form 1");
    }
}