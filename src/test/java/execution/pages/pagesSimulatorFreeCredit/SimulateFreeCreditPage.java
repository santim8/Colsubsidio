package execution.pages.pagesSimulatorFreeCredit;

import execution.enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class SimulateFreeCreditPage extends BasePage {

    @FindBy(xpath = "//p[text()='Simula tu crédito']")
    private WebElement title;

    @FindBy(xpath = "//p[contains(text(), 'Explora diferentes formas de pagar tu crédito')]")
    private WebElement description;

    @FindBy(id = ":r1:")
    private WebElement inputRegistrationNumber;

    @FindBy(className = "PrivateSwitchBase-input")
    private WebElement checkboxTermsAndConditions;

    @FindBy(xpath = "//button[.//p[text()='Continuar']]")
    private WebElement continueButton;

    public SimulateFreeCreditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SimulateFreeCreditPage enterRegistrationNumber(String registrationNumber) {
        sendKeys(inputRegistrationNumber, WaitStrategy.VISIBLE, registrationNumber);
        //inputRegistrationNumber.sendKeys(registrationNumber);
        return this;
    }

    public SimulateFreeCreditPage markCheckboxTermsAndConditions() {
        click(checkboxTermsAndConditions, WaitStrategy.NONE);
        return this;
    }

    public SimulateFreeCreditPage clickOnContinueButton() {
        click(continueButton, WaitStrategy.CLICKABLE, "Continue_button");
        return this;
    }
}
