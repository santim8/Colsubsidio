package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SetDriver {

    private WebDriver driver;

    public void setDriver() {
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        this.setDriver();
        if (driver != null) {
            return this.driver;
        }
        System.out.println("Driver is not initialized. Please call setDriver() first.");
        return null;
    }
}
