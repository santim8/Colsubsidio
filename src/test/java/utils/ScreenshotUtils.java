package utils;

import execution.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


final public class ScreenshotUtils {

    private ScreenshotUtils (){}

    public static String getBase64Image() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        return ts.getScreenshotAs(OutputType.BASE64);
    }
}
