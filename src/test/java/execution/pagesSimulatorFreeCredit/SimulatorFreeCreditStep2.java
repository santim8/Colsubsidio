package execution.pagesSimulatorFreeCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.basePage.BasePage;

public class SimulatorFreeCreditStep2 extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'Comencemos')]")
    private WebElement title;

    @FindBy(xpath = "//label[contains(text(), '¿Cuánto dinero necesitas?']")
    private WebElement amountLabel;

    @FindBy(xpath = "//label[contains(text(), '¿A cuántas cuotas quieres pagar?']")
    private WebElement quantityLabel;

    @FindBy(id = ":r2:")
    private WebElement inputAmount;

    @FindBy(id = ":r3:")
    private WebElement inputQuantity;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Continuar')]]")
    private WebElement buttonContinuar;

    @FindBy(id = ":r2:-label")
    private WebElement inputAmountLabel;

    @FindBy(id = ":r3:-label")
    private WebElement inputQuantityLabel;

    public SimulatorFreeCreditStep2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*public String getAmountLabel() {
        wait.until(ExpectedConditions.visibilityOf(amountLabel));
        return amountLabel.getText();
    }*/

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    public WebElement getQuantityLabel() {
        return quantityLabel;
    }

    public SimulatorFreeCreditStep2 enterQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(inputQuantity));
        inputQuantity.sendKeys(quantity);
        return this;
    }

    public SimulatorFreeCreditStep2 enterAmount(String amount){
        wait.until(ExpectedConditions.visibilityOf(inputAmount));
        inputAmount.sendKeys(amount);
        return this;
    }

    public WebElement getButtonContinuar() {
        wait.until(ExpectedConditions.visibilityOf(inputAmount));
        return buttonContinuar;
    }

    public SimulatorFreeCreditStep2 clickOnButtonContinuar() {
        wait.until(ExpectedConditions.visibilityOf(buttonContinuar));
        if (buttonContinuar.isEnabled()) {
            buttonContinuar.click();
        }
        return this;
    }

    public String getInputAmountLabel() {
        wait.until(ExpectedConditions.visibilityOf(inputAmountLabel));
        return inputAmountLabel.getText();
    }

    public String getInputQuantityLabel() {
        wait.until(ExpectedConditions.visibilityOf(inputQuantityLabel));
        return inputQuantityLabel.getText();
    }

    public WebElement webElementTitle(){
        wait.until(ExpectedConditions.visibilityOf(title));
        return title;
    }

    public WebElement getInputQuantity() {
        wait.until(ExpectedConditions.visibilityOf(inputQuantity));
        return inputQuantity;
    }

    public WebElement getInputAmount() {
        wait.until(ExpectedConditions.visibilityOf(inputAmount));
        return inputAmount;
    }

    public WebElement getAmountLabel() {
        return amountLabel;
    }
}