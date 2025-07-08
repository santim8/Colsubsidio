package execution.driver;

import java.net.MalformedURLException;
import java.util.Objects;

/**
 * The Driver class provides utility methods to initialize and quit a WebDriver instance
 * for test execution. It encapsulates the driver creation and teardown logic, ensuring
 * proper browser setup and management.
 *
 * This class is designed as a final utility class and cannot be instantiated.
 * It interacts with {@code DriverManager} and {@code DriverFactory} to handle
 * the underlying WebDriver instances.
 */
final public class Driver {

    private Driver(){}

    public static void initDriver(String browser, String url) {
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
              //  throw new Exception("Please check the capabilities of browser");
                //TODO completar Exception
            }
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(url);
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
