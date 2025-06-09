package execution.pagesSimulatorFreeCredit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.basePage.BasePage;

public class SimulatorFreeCreditStep3 extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'Resultado de tu simulación')]")
    private WebElement title;

    @FindBy(xpath = "//p[contains(text(), 'Cuota Mensual')]")
    private WebElement description;

    @FindBy(xpath = "//span[contains(text(), 'Mostrar detalles')]")
    private WebElement spanMostrarDetails;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Tasa efectiva anual')]]")
    private WebElement linkTasaEfectivaAnual;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Tasa Nominal M.V')]]")
    private WebElement linkTasaNominal;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Seguros')]]")
    private WebElement linkSeguros;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Entendido')]]")
    private WebElement buttonEntendido;

    @FindBy(xpath = "//p[contains(text(), 'Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo.')]")
    private WebElement textModalTasaAnual;

    @FindBy(xpath = "//p[contains(text(), 'Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo.')]")
    private WebElement textModalTasaNominal;

    @FindBy(xpath = "//p[contains(text(), 'Es un respaldo financiero que cubre pérdidas')]")
    private WebElement textModalSeguros;

    @FindBy(xpath = "//span[text()='Tasa efectiva anual']//following::div[@class='css-94nzlf']//p[contains(text(), '%')]")
    private WebElement percentageElementTasaEfectivaAnual;

    @FindBy(xpath = "//span[contains(text(), 'Tasa Nominal M.V')]//following::div[@class = 'css-94nzlf']//p[contains(text(), '%')]")
    private WebElement percentageElementTasaNominal;

    public SimulatorFreeCreditStep3(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public WebElement getWebElementTitle() {
        return title;
    }

    public String getDescription() {
        return description.getText();
    }

    public void clickOnMostrarDetails() {
        spanMostrarDetails.click();
    }

    public void clickOnLinkTasaEfectivaAnual() {
        linkTasaEfectivaAnual.click();
    }

    public void clickOnLinkTasaNominal() {
        linkTasaNominal.click();
    }

    public void clickOnLinkSeguros() {
        linkSeguros.click();
    }

    public void clickOnButtonEntendido() {
        buttonEntendido.click();
    }

    public String getTextModalTasaAnual() {
        wait.until(ExpectedConditions.visibilityOf(textModalTasaNominal));
        return textModalTasaAnual.getText();
    }

    public String getTextModalTasaNominal() {
        wait.until(ExpectedConditions.visibilityOf(textModalTasaNominal));
        return textModalTasaNominal.getText();
    }

    public String getTextModalSeguros() {
        wait.until(ExpectedConditions.visibilityOf(textModalSeguros));
        return textModalSeguros.getText();
    }

    public String getPercentageElement() {
        wait.until(ExpectedConditions.visibilityOf(percentageElementTasaEfectivaAnual));
        return percentageElementTasaEfectivaAnual.getText();
    }

    public String getPercentageElementTasaNominal() {
        wait.until(ExpectedConditions.visibilityOf(percentageElementTasaNominal));
        return percentageElementTasaNominal.getText();
    }

    public Boolean getTextXpathNodeP(String text) {
        String xpath = "//p[text()='" + text+"']";
        try {
            WebElement webElement = driver.findElement(By.xpath(xpath));
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
