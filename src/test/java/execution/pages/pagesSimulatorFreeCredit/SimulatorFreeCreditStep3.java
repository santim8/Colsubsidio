package execution.pages.pagesSimulatorFreeCredit;

import execution.enums.WaitStrategy;
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

    @FindBy(xpath = "//p[contains(text(), 'Es un respaldo financiero que cubre')]")
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

    public SimulatorFreeCreditStep3 validateTitle() {
        getText(title, WaitStrategy.VISIBLE, "title");
        return this;
    }

    public WebElement getWebElementTitle() {
        return title;
    }

    public SimulatorFreeCreditStep3 validateDescription() {
        getText(description, WaitStrategy.VISIBLE, "title");
        return this;
    }

    public SimulatorFreeCreditStep3 clickOnMostrarDetails() {
        click(spanMostrarDetails, WaitStrategy.CLICKABLE);
        return this;
    }

    public SimulatorFreeCreditStep3 clickModalAnnualRate() {
        linkTasaEfectivaAnual.click();
        return this;
    }

    public SimulatorFreeCreditStep3 clickModalNominalRate() {
        linkTasaNominal.click();
        return this;
    }

    public SimulatorFreeCreditStep3 clickModalInsurance() {
        linkSeguros.click();
        return this;
    }

    public SimulatorFreeCreditStep3 clickButtonUnderstood() {
        buttonEntendido.click();
        return this;
    }

    public SimulatorFreeCreditStep3 validatePurchaseValue() {
        getText(textValorCompra, WaitStrategy.VISIBLE, "purchse_value");
        return this;
    }

    public SimulatorFreeCreditStep3 validateNumberQuote() {
        getText(textNumeroCuotas, WaitStrategy.VISIBLE, "title");
        return this;
    }

    public SimulatorFreeCreditStep3 validateSummaryText() {
        getText(summaryText, WaitStrategy.VISIBLE, "title");
        return this;
    }

    public SimulatorFreeCreditStep3 validateModalAnnualRate() {
        getText(textModalTasaNominal, WaitStrategy.VISIBLE, "annal_rate");
        return this;
    }

    public SimulatorFreeCreditStep3 validateModalNominalRate() {
        getText(textModalTasaNominal, WaitStrategy.VISIBLE, "nominal_rate");
        return this;
    }

    public SimulatorFreeCreditStep3 validateModalInsurance() {
        getText(textModalSeguros, WaitStrategy.VISIBLE, "modal_insurance");
        return this;
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
        String xpath = "//p[contains(text(),'" + text + ")']";
        try {
            WebElement webElement = driver.findElement(By.xpath(xpath));
            System.out.println("WebElement found: " + webElement.getText());
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
