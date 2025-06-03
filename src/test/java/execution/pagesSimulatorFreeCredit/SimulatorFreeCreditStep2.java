package execution.pagesSimulatorFreeCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

/*
    @FindBy(xpath = "//button[.//p[text()='Continuar']]")
*/
    @FindBy(xpath = "//button[.//span[contains(text(), 'Continuar')]]")
    private WebElement buttonContinuar;

    public SimulatorFreeCreditStep2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public String getAmountLabel() {
        return amountLabel.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public WebElement getQuantityLabel() {
        return quantityLabel;
    }

    public void enterQuantity(String quantity){
        inputQuantity.sendKeys(quantity);
    }

    public void enterAmount(String amount){
        inputAmount.sendKeys(amount);
    }

    public WebElement getButtonContinuar() {
        return buttonContinuar;
    }

    public void clickOnButtonContinuar() {
        if (buttonContinuar.isEnabled()) {
            buttonContinuar.click();
        }
    }

    public WebElement webElementTitle(){
        return title;
    }
}