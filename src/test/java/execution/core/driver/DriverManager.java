package execution.core.driver;

import org.openqa.selenium.WebDriver;
import java.util.Objects;

public class DriverManager {

    public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    private DriverManager(){}

    public static WebDriver getDriver(){
        return dr.get();
    }

    static void setDriver(WebDriver driverRef){
        if(Objects.nonNull(driverRef)) {
            dr.set(driverRef);
        }
    }

    static void unload(){
        dr.remove();
    }
}
