package execution.tests;


import execution.data.DataProviderUtil;
import execution.enums.EnumsDropdowns;
import execution.pages.pagesQuotaCredit.Login;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding1;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding2;
import execution.pages.pagesQuotaCredit.SolicitudCreditoOnboarding3;
import execution.pages.pagesQuotaCredit.requestFlow.RequestCreditStep1;
import execution.pages.pagesSimulatorFreeCredit.SimulateFreeCreditPage;
import execution.repositories.ReportImplementation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;

import javax.swing.*;

public class RequestQuotaCreditTest extends BaseTest {

    private BasePage basePage;
    private Login login;
    private SolicitudCreditoOnboarding1 solicitudCreditoOnboarding1;
    private SolicitudCreditoOnboarding2 solicitudCreditoOnboarding2;
    private SolicitudCreditoOnboarding3 solicitudCreditoOnboarding3;
    private RequestCreditStep1 requestCreditStep1;
    private SimulateFreeCreditPage simulateFreeCreditPage;

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
    private void testMethod(String identification, String password) {
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
                .enterIdentification(identification)
                .enterPassword(password);

        ReportImplementation.flush();
        JOptionPane.showMessageDialog(null,
                "🔐 Please complete the login/CAPTCHA in browser.\nClick OK to continue automation.");

       /* simulateFreeCreditPage
                .markCheckboxTermsAndConditions()
                .clickOnContinueButton();


        requestCreditStep1
                .enterInputNumeroTelefono("3001234567")
                .enterInputCorreo("santiagocorea@200gmail.com")
                .enterInputConfirmarCorreo("santiagocorea@200gmail.com")
                .clickButtonContinuar()
                .clickOnDropdownEstadoCivil()
                .selectOptionsEstadoCivil(EnumsDropdowns.SOLTERO.getValue())
                .clickOnDropdownNivelEstudio()
                .selectOptionsNivelEstudio(EnumsDropdowns.PRIMARIA.getValue())
                .clickButtonContinuar()
                .selectOptionTipoVivienda()
                .clickButtonContinuar()
                .selectOptionObraLabor()
                .clickButtonContinuar()
                .enterInputSalarioMensual("10000000")
                .clickButtonContinuar();*/
    }
}
