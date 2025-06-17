package execution.repositories;

import execution.driver.DriverManager;
import execution.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, WebElement element) {
        WebElement elementToReturn = null;


        if (waitStrategy == WaitStrategy.CLICKABLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.elementToBeClickable(element));

        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated((By) element));

        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            elementToReturn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOf(element));
        }

        // If the strategy is NONE, no need to wait, just return the element.
        else if (waitStrategy == WaitStrategy.NONE) {
            elementToReturn = element;
        }

        return elementToReturn;
    }
}
