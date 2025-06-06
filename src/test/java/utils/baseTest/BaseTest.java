package utils.baseTest;

import execution.pagesQuotaCredit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.SetDriver;
import utils.basePage.BasePage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    @Parameters("url")
    public void beforeMethod(String url) {
        this.driver = new SetDriver().getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().window().maximize();
        driver.get(url);
/*
        driver.get("https://www.colsubsidio.com/creditos/cupo");
*/
        /*        driver.get("https://nginx-transacciones.platform-test-external.colsubsidio.com/creditos/solicitud/cupo-de-credito/onboarding");*/
    }

  /*  @Test
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
    }*/

    @AfterMethod
    public void afterMethod() {
        this.driver.close();
    }
}
