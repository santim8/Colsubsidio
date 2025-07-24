package utils.baseTest;

import com.globant.aut.javacore.validators.exceptions.AugmentedException;
import com.globant.aut.sdk.AutSDKProperties;
import com.globant.aut.sdk.figma.FigmaProperties;
import execution.driver.Driver;
import execution.driver.DriverManager;
import execution.magnifie.MagnifaiManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;


public class BaseTest {
    protected WebDriver driver;

//    @BeforeSuite
//    public void beforeSuite() throws IOException {
//        AutSDKProperties.resetDefaults();
//        FigmaProperties.loadPropertyFile("figma.properties");
//        AutSDKProperties.loadPropertyFile("sdk.properties");
//
//
//        CompletableFuture<Void> figmaProperties = CompletableFuture.runAsync(() -> {
//            try {
//                FigmaProperties.loadPropertyFile("figma.properties");
//            } catch (IOException e) {
////                logger.error("Error loading Figma properties", e);
//            }
//        });
//
//        CompletableFuture<Void> sdkProperties = CompletableFuture.runAsync(() -> {
//            try {
//                AutSDKProperties.loadPropertyFile("sdk.properties");
//            } catch (IOException e) {
////                logger.error("Error loading SDK properties", e);
//            }
//        });
//
//        // Esperar a que todo termine
//        CompletableFuture.allOf(figmaProperties, sdkProperties).join();
//        try {
//            MagnifaiManager.setProjectId();
//            MagnifaiManager.setExecutionId();
//        } catch (AugmentedException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//    }

    @BeforeMethod
    @Parameters({"url"})
    public void beforeMethod(String url) {
        Driver.initDriver("chrome", url);
        this.driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
//        Driver.quitDriver();
    }
}
