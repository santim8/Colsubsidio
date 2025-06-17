package utils.baseTest;

import execution.driver.Driver;
import execution.driver.DriverManager;
import execution.repositories.ReportImplementation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest  {
    protected WebDriver driver;
    protected String url;

    @BeforeMethod
    @Parameters({"url"})
    public void beforeMethod(String url) {

        Driver.initDriver("chrome", url);
        ReportImplementation.initialize();
        ReportImplementation.setTest("Test_url");
        this.driver = DriverManager.getDriver();


    /*    this.url = url;
        this.driver = new ManageDriver().getDriver();
        driver.manage().window().maximize();
        driver.get(url);*/
    }

    @AfterMethod
    public void afterMethod() {
        Driver.quitDriver();
    }
}
