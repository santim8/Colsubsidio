package execution.tests;


import execution.pages.pagesQuotaCredit.Login;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding1;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding2;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding3;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;

public class RequestQuotaCreditTest extends BaseTest {

    private BasePage basePage;
    private SolicitudCreditoOnboarding1 solicitudCreditoOnboarding1;
    private SolicitudCreditoOnboarding2 solicitudCreditoOnboarding2;
    private SolicitudCreditoOnboarding3 solicitudCreditoOnboarding3;
    private Login login;

    @BeforeMethod
    private void setUp() {
        basePage = new BasePage(driver);
        login = new Login(driver);
        solicitudCreditoOnboarding1 = new SolicitudCreditoOnboarding1(driver);
        solicitudCreditoOnboarding2 = new SolicitudCreditoOnboarding2(driver);
        solicitudCreditoOnboarding3 = new SolicitudCreditoOnboarding3(driver);
    }


    @Test
    private void testMethod() {
        basePage
                .clickDetailsButton()
                .clickOnProceedLink();

        Assert.assertEquals(solicitudCreditoOnboarding1.getTitle(), "¡Empieza tu solicitud digital!");
        solicitudCreditoOnboarding1.clickOnButtonSiguiente();

        Assert.assertEquals(solicitudCreditoOnboarding2.getTitle(), "Conoce los requisitos");
        solicitudCreditoOnboarding2.clickOnNExtButton();

        Assert.assertEquals(solicitudCreditoOnboarding3.getTitle(), "Ten en cuenta lo siguiente");
        solicitudCreditoOnboarding3.clickOnStartButton();

        login
                .enterIdentification("1023013419")
                .enterPassword("Colsubsidio2025.");

    }
}
