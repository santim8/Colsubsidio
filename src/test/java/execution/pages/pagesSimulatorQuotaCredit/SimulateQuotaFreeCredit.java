package execution.pages.pagesSimulatorQuotaCredit;

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

    public SimulateQuotaFreeCredit(WebDriver driver) {
        super(driver);
    }

    public String getDescription() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return description.getText();
    }


    public WebElement getDocumentType() {
        wait.until(ExpectedConditions.visibilityOf(documentType));
        return documentType;
    }

    public WebElement getDocumentNumber() {
        wait.until(ExpectedConditions.visibilityOf(documentNumber));
        return documentNumber;
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }
}
