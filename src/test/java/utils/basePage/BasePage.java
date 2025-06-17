package utils.basePage;

import com.aventstack.extentreports.Status;
import execution.enums.WaitStrategy;
import execution.repositories.ExplicitWaitFactory;
import execution.repositories.ReportImplementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        click(detailsButton, WaitStrategy.CLICKABLE, "Details_Button");
        return this;
    }

    public BasePage clickOnProceedLink() {
        click(proceedLink, WaitStrategy.CLICKABLE, "Open_link_Button");
        return this;
    }

    public WebElement getRestriction() {
        return restrictionText;
    }

    protected void click(WebElement element, WaitStrategy waitStrategy, String elementName) {
        ReportImplementation.sendLog(Status.PASS, elementName + " is clicked");
        ExplicitWaitFactory.performExplicitWait(waitStrategy, element).click();
    }

    protected void sendKeys(WebElement element, WaitStrategy waitStrategy, String data) {
        ReportImplementation.sendLog(Status.PASS, "the data " + data + "+ is sent to the element");
        ExplicitWaitFactory.performExplicitWait(waitStrategy, element).sendKeys(data);
    }
}