package execution.driver;

import java.net.MalformedURLException;
import java.util.Objects;

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
