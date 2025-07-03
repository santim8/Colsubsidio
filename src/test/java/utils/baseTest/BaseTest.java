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
        ExtentReport.addTestCategories(new CategoryType[] {CategoryType.SMOKE, CategoryType.REGRESSION});
        ExtentReport.addAuthor("Santiago Correa");
        ExtentReport.addTestID("TC-001");
        Driver.quitDriver();
    }
}
