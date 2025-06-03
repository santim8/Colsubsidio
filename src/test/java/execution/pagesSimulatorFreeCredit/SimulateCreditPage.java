package execution.pagesSimulatorFreeCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class SimulateCreditPage extends BasePage {


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

    public SimulateCreditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {return description.getText();}

    public void setInputRegistrationNumber(String registrationNumber) {
        inputRegistrationNumber.sendKeys(registrationNumber);
    }

    public void markCheckboxTermsAndConditions() {
        if (!checkboxTermsAndConditions.isSelected()) {
            checkboxTermsAndConditions.click();
        }
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
