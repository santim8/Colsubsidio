package execution.pages.pagesSimulatorQuotaCredit;

import execution.enums.WaitStrategy;
import execution.pages.pagesSimulatorFreeCredit.SimulateFreeCreditPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SimulateQuotaFreeCredit extends SimulateFreeCreditPage {

    @FindBy(xpath = "//p[contains(text(), 'Simula tu compra')]")
    private WebElement title;


    @FindBy(xpath = "//p[contains(text(), 'Explora diferentes formas de pagar tu compra a cuotas.')]")
    private WebElement description;

    @FindBy(id  = "documentType")
    private WebElement documentType;

    @FindBy(id = ":r1:-label")
    private WebElement documentNumber;

    @FindBy(xpath = "//button[.//p[text()='Continuar']]")
    private WebElement nextButton;

    public SimulateQuotaFreeCredit(WebDriver driver) {
        super(driver);
    }

    public SimulateQuotaFreeCredit validateDescription() {
        getText(description, WaitStrategy.VISIBLE, "title");
        return this;
    }


    public SimulateQuotaFreeCredit validateDocumentType() {
        getText(documentType, WaitStrategy.VISIBLE, "documentType");
        return this;
    }

    public SimulateQuotaFreeCredit validateDocumentNumber() {
        getText(documentNumber, WaitStrategy.VISIBLE, "documentType");
        return this;
    }

    public SimulateQuotaFreeCredit validateTitle() {
        getText(title, WaitStrategy.VISIBLE, "documentType");
        return this;
    }

    public SimulateFreeCreditPage clickNextButton() {
        click(nextButton, WaitStrategy.CLICKABLE);
        return this;
    }
}
