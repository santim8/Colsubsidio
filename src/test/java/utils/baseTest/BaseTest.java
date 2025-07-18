package utils.baseTest;

import execution.driver.Driver;
import execution.driver.DriverManager;
import execution.enums.CategoryType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import reports.ExtentReport;


public class BaseTest  {
    protected WebDriver driver;
    protected String url;

    @BeforeMethod
    @Parameters({"url"})
    public void beforeMethod(String url) {
        Driver.initDriver("chrome", url);
        this.driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        Driver.quitDriver();
    }
}
