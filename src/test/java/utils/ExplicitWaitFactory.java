package utils;

import execution.core.driver.DriverManager;
import execution.core.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * The ExplicitWaitFactory class provides methods to perform explicit waits
 * for web elements using different wait strategies such as CLICKABLE, PRESENCE,
 * VISIBLE, or NONE. It utilizes WebDriverWait with configurable timeout durations
 * to ensure that interactions with web elements only proceed when specific conditions
 * are met. This helps enhance synchronization and reliability during automation execution.
 */
public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, WebElement element) {
        WebElement elementToReturn = null;


        if (waitStrategy == WaitStrategy.CLICKABLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(element));

        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3))
                    .until(ExpectedConditions.presenceOfElementLocated((By) element));

        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(element));
        } else if (waitStrategy == WaitStrategy.NONE) {
            elementToReturn = element;
        }

        return elementToReturn;
    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, WebElement element, Integer seconds) {
        WebElement elementToReturn = null;


        if (waitStrategy == WaitStrategy.CLICKABLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.elementToBeClickable(element));

        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.presenceOfElementLocated((By) element));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOf(element));
        } else if (waitStrategy == WaitStrategy.NONE) {
            elementToReturn = element;
        }

        return elementToReturn;
    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By element) {
        WebElement elementToReturn = null;

        if (waitStrategy == WaitStrategy.CLICKABLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(4))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(4))
                    .until(ExpectedConditions.presenceOfElementLocated(element));

        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if (waitStrategy == WaitStrategy.NONE) {
            elementToReturn = (WebElement) element;
        }
        return elementToReturn;
    }
}
