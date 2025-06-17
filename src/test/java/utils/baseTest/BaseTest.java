package utils.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.SetDriver;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url;

    @BeforeMethod
    @Parameters({"url"})
    public void beforeMethod(String url) {
        this.url = url;
        this.driver = new SetDriver().getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().window().maximize();
        driver.get(url);
/*
        driver.get("https://transacciones.colsubsidio.com/creditos/simulador/cupo-de-credito/identificate");
*/
    }

    @AfterMethod
    public void afterMethod() {
       /* this.driver.close();*/
    }
}
