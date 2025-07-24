package utils.basePage;

import execution.enums.WaitStrategy;
import execution.magnifie.MagnifaiManager;
import execution.repositories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;
import utils.ScreenshotUtils;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    protected void click(WebElement element, WaitStrategy waitStrategy, String elementName) {
        try {
            ExplicitWaitFactory.performExplicitWait(waitStrategy, element).click();
            ExtentLogger.pass(elementName + "was clicked correctly");
        } catch (Exception e) {
            ExtentLogger.fail("the click Failed error: " + element.getText() + ": " + e.getMessage());
        }
    }

    protected void click(WebElement element, WaitStrategy waitStrategy) {
        try {
            ExplicitWaitFactory.performExplicitWait(waitStrategy, element).click();
        } catch (Exception e) {
            ExtentLogger.fail("the click Failed error: " + element.getText() + ": " + e.getMessage());
        }
    }

    protected void click(By element, WaitStrategy waitStrategy) {
        try {
            ExplicitWaitFactory.performExplicitWait(waitStrategy, element).click();
        } catch (Exception e) {
            ExtentLogger.fail("the click Failed error: " + e.getMessage());
        }
    }

    protected void sendKeys(WebElement element, WaitStrategy waitStrategy, String data) {
        try {
            ExplicitWaitFactory.performExplicitWait(waitStrategy, element, 10).sendKeys(data);
            ExtentLogger.pass("The information " + data + " entered correctly");
        } catch (Exception e) {
            ExtentLogger.fail("Failed to retrieve text from " + element.getText() + ": " + e.getMessage());
        }
    }

    protected String getText(WebElement element, WaitStrategy waitStrategy, String elementName) {
        try {
            WebElement waited = ExplicitWaitFactory.performExplicitWait(waitStrategy, element);
            String text = waited.getText();
            ExtentLogger.pass("<b> text retrieved: </b>" + text);
            return text;
        } catch (Exception e) {
            ExtentLogger.fail("Failed to retrieve text from " + elementName + ": " + e.getMessage());
            return null;
        }
    }

    protected String getText(WebElement element, WaitStrategy waitStrategy, String elementName, Integer secondsWait) {
        try {
            WebElement waited = ExplicitWaitFactory.performExplicitWait(waitStrategy, element, secondsWait);
            String text = waited.getText();
            ExtentLogger.pass("<b> text retrieved: </b>" + text);
            return text;
        } catch (Exception e) {
            ExtentLogger.fail("Failed to retrieve text from " + elementName + ": " + e.getMessage());
            return null;
        }
    }

    public <T> T waitInteractionUser(T currentPage, String message) {
        JOptionPane.showMessageDialog(null,
                message, "Manual Action Required", JOptionPane.INFORMATION_MESSAGE);
        return currentPage;
    }

    public <T> T takeScreenshotReport(T currentPage, String screenshotName) {
        ExtentLogger.info(screenshotName, true);
        return currentPage;
    }

    //this code is stored in the system
    public <T> T takeScreenshotAndSaveItLocal(T currentPage, String screenshotName) throws IOException {
        ScreenshotUtils.captureAndSaveScreenshot(screenshotName);
        return currentPage;
    }

    public <T> T actionMessage(T currentPage, String message) {
        ExtentLogger.info(message);
        return currentPage;
    }

    public <T> T setDimensionsScreen(T currentPage, int width, int height) throws IOException, InterruptedException {
        MagnifaiManager.setViewPort(width,height);
        return currentPage;
    }

    public void setDimensionsScreen(int width, int height) throws IOException, InterruptedException {
        MagnifaiManager.setViewPort(width,height);
    }
}