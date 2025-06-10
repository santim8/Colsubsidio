package execution.pagesSimulatorQuotaCredit;

import execution.pagesSimulatorFreeCredit.SimulateCreditPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SimulateQuotaCredit extends SimulateCreditPage {

    @FindBy(xpath = "//p[contains(text(), 'Simula tu compra')]")
    private WebElement title;


    @FindBy(xpath = "//p[contains(text(), 'Explora diferentes formas de pagar tu compra a cuotas.')]")
    private WebElement description;

    @FindBy(id  = "documentType")
    private WebElement documentType;

    @FindBy(id = ":r1:-label")
    private WebElement documentNumber;

    public SimulateQuotaCredit(WebDriver driver) {
        super(driver);
    }

    public String getDescription() {
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

    public String getTitle() { return title.getText();}
}
