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
        driver.get("https://nginx-transacciones.platform-test-external.colsubsidio.com/creditos/solicitud/cupo-de-credito/onboarding");
    }

    @AfterMethod
    public void afterMethod() {
        this.driver.close();
    }
}
