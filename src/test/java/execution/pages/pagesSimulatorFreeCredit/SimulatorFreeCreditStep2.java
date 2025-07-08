package execution.pages.pagesSimulatorFreeCredit;

import execution.enums.WaitStrategy;
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

    @FindBy(id = ":r4:")
    private WebElement inputAmountQuota;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Continuar')]]")
    private WebElement nextButton;

    @FindBy(id = ":r2:-label")
    private WebElement inputAmountLabel;

    @FindBy(id = ":r3:-label")
    private WebElement inputQuantityLabel;

    @FindBy(xpath = "//button[.//p[contains(text(), 'Valor')]]")
    private WebElement buttonValor;

    public SimulatorFreeCreditStep2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public SimulatorFreeCreditStep2 validateTitle() {
        getText(title, WaitStrategy.VISIBLE, "title", 5);
        return this;
    }

    public WebElement getQuantityLabel() {
        return quantityLabel;
    }

    public SimulatorFreeCreditStep2 enterQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(inputQuantity));
        inputQuantity.sendKeys(quantity);
        return this;
    }

    public SimulatorFreeCreditStep2 enterAmount(String amount) {
        sendKeys(inputAmount, WaitStrategy.VISIBLE, amount);
        return this;
    }

    public WebElement getNextButton() {
        wait.until(ExpectedConditions.visibilityOf(inputAmount));
        return nextButton;
    }

    public SimulatorFreeCreditStep2 clickNextButton() {
        click(nextButton, WaitStrategy.CLICKABLE);
        return this;
    }

    public SimulatorFreeCreditStep2 validateAmountLabel() {
        getText(inputAmountLabel, WaitStrategy.VISIBLE, "input_amount_label");
        return this;
    }

    public SimulatorFreeCreditStep2 validateQuantityLabel() {
        getText(inputQuantityLabel, WaitStrategy.VISIBLE, "input_quantity_label");
        return this;
    }

    public WebElement webElementTitle() {
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

    public SimulatorFreeCreditStep2 enterInputAmountQuota(String amountQuota) {
        wait.until(ExpectedConditions.visibilityOf(inputAmountQuota));
        inputAmountQuota.sendKeys(amountQuota);
        return this;
    }

    public SimulatorFreeCreditStep2 clickButtonValor() {
        wait.until(ExpectedConditions.visibilityOf(buttonValor));
        if (buttonValor.isEnabled()) {
            buttonValor.click();
        }
        return this;
    }
}