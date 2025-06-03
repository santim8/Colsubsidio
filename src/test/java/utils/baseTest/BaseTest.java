package utils.baseTest;
import execution.pagesQuotaCredit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.SetDriver;
import utils.basePage.BasePage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void beforeMethod() {
        this.driver = new SetDriver().getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
/*
        driver.get("https://www.colsubsidio.com/creditos/cupo");
*/
/*        driver.get("https://nginx-transacciones.platform-test-external.colsubsidio.com/creditos/solicitud/cupo-de-credito/onboarding");*/
        driver.get("https://nginx-transacciones.platform-test-external.colsubsidio.com/creditos/simulador/libre-inversion/identificate");
    }

    @Test
    public void testLogin() {
        BasePage basePage = new BasePage(driver);
        basePage.clickDetailsButton();
        basePage.clickOnProceedLink();
        SolicitudCreditoOnboarding1 solicitudCupoCreditoOnboarding1 = new SolicitudCreditoOnboarding1(driver);
        Assert.assertEquals(solicitudCupoCreditoOnboarding1.getTitle(), "¡Empieza tu solicitud digital!");
        solicitudCupoCreditoOnboarding1.clickOnButtonSiguiente();

        SolicitudCreditoOnboarding2 solicitudCreditoOnboarding2 = new SolicitudCreditoOnboarding2(driver);
        Assert.assertEquals(solicitudCreditoOnboarding2.getTitle(), "Conoce los requisitos");
        solicitudCreditoOnboarding2.clickOnNExtButton();

        SolicitudCreditoOnboarding3 solicitudCreditoOnboarding3 = new SolicitudCreditoOnboarding3(driver);
        Assert.assertEquals(solicitudCreditoOnboarding3.getTitle(),"Ten en cuenta lo siguiente");
        solicitudCreditoOnboarding3.clickOnStartButton();

        Login login = new Login(driver);
        login.enterIdentification("1234567890");
        login.enterPassword("tin12242");




   /*     String tin = basePage.getCupoDeCreditoText().getText();
        Assert.assertEquals(basePage.getCupoDeCreditoText().getText(), "Cupo de Crédito en tu Tarjeta de Afiliación");
        basePage.clickOnSelectCupo()*/;
     /*   SolicitudCupoCredito solicitudCupoCredito = new SolicitudCupoCredito(driver);
        String title = solicitudCupoCredito.getCupoDeCreditoText().getText();
        Assert.assertEquals(solicitudCupoCredito.getCupoDeCreditoText().getText(), "Cupo de Crédito en tu Tarjeta de Afiliación");
        Assert.assertEquals(solicitudCupoCredito.getTitle().getText(), "Solicitud de cupo de crédito");*/
/*        solicitudCupoCredito.clickNextButton();*/
        // Implement your test logic here
        // For example, you can use the driver to interact with the login page
        // and perform assertions on the login functionality.
    }
}
