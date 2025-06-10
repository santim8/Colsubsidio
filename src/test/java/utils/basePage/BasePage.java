package utils.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SetDriver;

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

    public BasePage() {
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void main(String [] args) {
        // Example usage
        WebDriver driver = new SetDriver().getDriver();
        BasePage basePage = new BasePage(driver);
        System.out.println("Driver: " + basePage.getDriver());
        System.out.println("Wait: " + basePage.getWait());
    }
    //
/*
    public void clickOnSelectCupo() {
        selectCupoCredito.click();
    }
*/

    public BasePage clickOnSelectCupo() {
        selectCupoCredito.click();
        return this; // Return the current instance for method chaining
    }

    public WebElement getCupoDeCreditoText() {
        return cupoDeCreditoText;
    }

/*    public void clickDetailsButton() {
        detailsButton.click();
    }*/

    public BasePage clickDetailsButton() {
        detailsButton.click();
        return this; // Return the current instance for method chaining
    }

  /*  public void clickOnProceedLink(){
        proceedLink.click();
    }*/
    public BasePage clickOnProceedLink() {
        proceedLink.click();
        return this; // Return the current instance for method chaining
    }

    public WebElement getRestrictionText() {
        return restrictionText;
    }
}
