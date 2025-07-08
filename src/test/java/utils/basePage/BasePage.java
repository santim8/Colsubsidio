package utils.basePage;

import execution.enums.WaitStrategy;
import execution.repositories.ExplicitWaitFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

import javax.swing.*;
import java.time.Duration;


public class BasePage {

    @FindBy(css = "a[href='https://transacciones.colsubsidio.com/creditos/solicitud/cupo-de-credito/onboarding']")
    protected WebElement selectCupoCredito;

    @FindBy(xpath = "//p[text()='Cupo de Crédito en tu Tarjeta de Afiliación']")
    private WebElement cupoDeCreditoText;

    @FindBy(id = "details-button")
    private WebElement detailsButton;

    @FindBy(id = "proceed-link")
    private WebElement proceedLink;

    @FindBy(xpath = "//p[contains(text(),'Los datos suministrados son aproximados')]")
    private WebElement restrictionText;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    protected BasePage clickOnSelectCupo() {
        selectCupoCredito.click();
        return this;
    }

    public WebElement getCupoDeCreditoText() {
        return cupoDeCreditoText;
    }

    public BasePage clickDetailsButton() {
        click(detailsButton, WaitStrategy.CLICKABLE);
        return this;
    }

    public BasePage clickProceedLink() {
        click(proceedLink, WaitStrategy.CLICKABLE);
        return this;
    }

    public WebElement validateRestriction() {
        return restrictionText;
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

    public <T> T takeScreenshot(T currentPage, String screenshotName) {
        ExtentLogger.info(screenshotName, true);
        return currentPage;
    }

    public <T> T actionMessage(T currentPage, String message) {
        ExtentLogger.info(message);
        return currentPage;
    }
}