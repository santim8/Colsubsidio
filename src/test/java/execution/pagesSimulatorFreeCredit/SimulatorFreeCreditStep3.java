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

    @FindBy(xpath = "//p[contains(text(), 'Valor de la compra')]")
    private WebElement textValorCompra;

    @FindBy(xpath = "//p[contains(text(), 'Número de cuotas')]")
    private WebElement textNumeroCuotas;

    @FindBy(xpath = "//p[contains(text(), 'Resumen')]")
    private WebElement summaryText;

    public SimulatorFreeCreditStep3(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    public WebElement getWebElementTitle() {
        return title;
    }

    public String getDescription() {
        wait.until(ExpectedConditions.visibilityOf(description));
        return description.getText();
    }

    public SimulatorFreeCreditStep3 clickOnMostrarDetails() {
        spanMostrarDetails.click();
        return this;
    }

    public SimulatorFreeCreditStep3 clickOnLinkTasaEfectivaAnual() {
        linkTasaEfectivaAnual.click();
        return this;
    }

    public SimulatorFreeCreditStep3 clickOnLinkTasaNominal() {
        linkTasaNominal.click();
        return this;
    }

    public SimulatorFreeCreditStep3 clickOnLinkSeguros() {
        linkSeguros.click();
        return this;
    }

    public SimulatorFreeCreditStep3 clickOnButtonEntendido() {
        buttonEntendido.click();
        return this;
    }

    public String getTextValorCompra() {
        wait.until(ExpectedConditions.visibilityOf(textValorCompra));
        return textValorCompra.getText();
    }

    public String getTextNumeroCuotas() {
        wait.until(ExpectedConditions.visibilityOf(textNumeroCuotas));
        return textNumeroCuotas.getText();
    }

    public String getSummaryText() {
        wait.until(ExpectedConditions.visibilityOf(summaryText));
        return summaryText.getText();
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
        String xpath = "//p[contains(text(),'" + text+")']";
        try {
            WebElement webElement = driver.findElement(By.xpath(xpath));
            System.out.println("WebElement found: " + webElement.getText());
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
