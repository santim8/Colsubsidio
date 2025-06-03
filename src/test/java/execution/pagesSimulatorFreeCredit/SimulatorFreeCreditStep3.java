package execution.pagesSimulatorFreeCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class SimulatorFreeCreditStep3 extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'Resultado de tu simulación')]")
    private WebElement title;

    @FindBy(xpath = "//p[contains(text(), 'Cuota Mensual')]")
    private WebElement description;

    @FindBy(xpath = "//span[contains(text(), 'Mostrar detalles')]")
    private WebElement spanMostrarDetails;

    public SimulatorFreeCreditStep3(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public void clickOnMostrarDetails() {
        spanMostrarDetails.click();
    }
}
