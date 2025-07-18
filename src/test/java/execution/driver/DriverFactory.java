package execution.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;
import java.util.Objects;

public class DriverFactory {


    /**
     * Private constructor to avoid external instantiation
     */
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;

        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                // Add this argument to ignore SSL certificate errors
                options.addArguments("--ignore-certificate-errors");
                // Optionally disable the security warning
                options.addArguments("--disable-web-security");
                options.addArguments("--allow-insecure-localhost");
                driver = new ChromeDriver(options);

            }
            return driver;
        }

        //TODO setiar diferentes browsers
        return driver;
    }
}