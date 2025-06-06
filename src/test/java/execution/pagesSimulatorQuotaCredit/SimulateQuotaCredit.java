package execution.pagesSimulatorQuotaCredit;

import execution.pagesSimulatorFreeCredit.SimulateCreditPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimulateQuotaCredit extends SimulateCreditPage {

    @FindBy(xpath = "//p[contains(text(), 'Simula tu compra')]")
    private WebElement title;


    @FindBy(xpath = "//p[contains(text(), 'Explora diferentes formas de pagar tu compra a cuotas.')]")
    private WebElement description;

    public SimulateQuotaCredit(WebDriver driver) {
        super(driver);
    }

    public String getDescription() {
        return description.getText();
    }

    public String getTitle() { return title.getText();}
}
