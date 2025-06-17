package execution.pages.pagesQuotaCredit.requestFlow;

import execution.enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

import java.util.List;

public class RequestCreditStep1 extends BasePage {

    @FindBy(id = ":r0:-label")
    private WebElement numeroTelefonoLabel;

    @FindBy(id = ":r0:")
    private WebElement inputNumeroTelefono;

    @FindBy(id = ":r1:-label")
    private WebElement correoLabel;

    @FindBy(id = ":r1:")
    private WebElement inputCorreo;

    @FindBy(id = ":r2:-label")
    private WebElement confirmarCorreoLabel;

    @FindBy(id = ":r2:")
    private WebElement inputConfirmarCorreo;

    @FindBy(xpath = "//button[.//span[.//p[text()='Continuar']]]")
    private WebElement buttonContinuar;

    @FindBy(id = "Pago arriendo")
    private WebElement optionTipoVivienda;

    @FindBy(id = "Por obra o labor")
    private WebElement optionObraLabor;

    @FindBy(id = ":r7:")
    private WebElement inputAmountMonth;

    @FindBy(xpath = "//div[@aria-controls=':r3:']")
    private WebElement dropdownEstadoCivil;

    @FindBy(xpath = "//div[@aria-controls=':r4:']")
    private WebElement dropdownNivelEstudio;

    @FindBy(xpath = "//ul[@id=':r3:']/li")
    private List<WebElement> optionsEstadoCivil;

    @FindBy(xpath = "//ul[@id=':r4:']/li")
    private List<WebElement> optionsNivelEstudio;

    public RequestCreditStep1(WebDriver driver) {
        super(driver);
    }

    public RequestCreditStep1 enterInputNumeroTelefono(String text) {
        sendKeys(inputNumeroTelefono, WaitStrategy.VISIBLE, text);
        return this;
    }

    public String getNumberPhoneLabelText() {
        return numeroTelefonoLabel.getText();
    }

    public RequestCreditStep1 enterInputConfirmarCorreo(String text) {
        sendKeys(inputConfirmarCorreo, WaitStrategy.VISIBLE, text);
        return this;
    }

    public RequestCreditStep1 enterInputCorreo(String text) {
        sendKeys(inputCorreo, WaitStrategy.VISIBLE, text);
        return this;
    }

    public String getEmailLabelText() {
        return correoLabel.getText();
    }

    public String getConfirmEmailLabelText() {
        return confirmarCorreoLabel.getText();
    }

    public RequestCreditStep1 clickButtonContinuar() {
        click(buttonContinuar, WaitStrategy.CLICKABLE, "Button_Continuar");
        return this;
    }

    public RequestCreditStep1 selectOptionTipoVivienda() {
        click(optionTipoVivienda, WaitStrategy.CLICKABLE, "Button_Continuar");
        return this;
    }

    public RequestCreditStep1 selectOptionObraLabor() {
        click(optionObraLabor, WaitStrategy.CLICKABLE, "Button_Continuar");
        return this;
    }

    public RequestCreditStep1 enterInputSalarioMensual(String text) {
        sendKeys(inputAmountMonth, WaitStrategy.VISIBLE, text);
        return this;
    }

    public RequestCreditStep1 clickOnDropdownEstadoCivil() {
        click(dropdownEstadoCivil, WaitStrategy.CLICKABLE, "Button_Continuar");
        return this;
    }

    public RequestCreditStep1 clickOnDropdownNivelEstudio() {
        click(dropdownNivelEstudio, WaitStrategy.CLICKABLE, "Button_Continuar");
        return this;
    }

    public List<WebElement> getOptionsNivelEstudio() {
        return optionsNivelEstudio;
    }

    public List<WebElement> getOptionsEstadoCivil() {
        return optionsEstadoCivil;
    }

    public RequestCreditStep1 selectOptionsEstadoCivil(String options) {
        for (WebElement item : optionsEstadoCivil) {
            if (item.getText().equals(options)) {
                item.click();
                break;
            }
        }
        return this;
    }

    public RequestCreditStep1 selectOptionsNivelEstudio(String options) {
        for (WebElement item : optionsNivelEstudio) {
            if (item.getText().equals(options)) {
                item.click();
                break;
            }
        }
        return this;
    }
}
