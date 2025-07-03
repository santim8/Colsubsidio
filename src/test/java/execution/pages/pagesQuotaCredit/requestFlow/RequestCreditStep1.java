package execution.pages.pagesQuotaCredit.requestFlow;

import execution.enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    private WebElement pagoArriendoRadioButton;

    @FindBy(xpath = "//p[text()='Por obra o labor']")
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

    @FindBy(xpath = "//p[text() = 'Pago arriendo']")
    private WebElement soyPropietarioRadioButton;

    @FindBy(xpath = "//p[text() = '¿Cuál es tu tipo de vivienda?']")
    private WebElement tipoViviendaLabel;

    public RequestCreditStep1 validateHousingTypeLabel() {
        getText(tipoViviendaLabel, WaitStrategy.VISIBLE, "Label_Tipo_Vivienda");
        click(soyPropietarioRadioButton, WaitStrategy.CLICKABLE);
        return this;
    }

    public RequestCreditStep1(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RequestCreditStep1 enterPhoneNumber(String text) {
        sendKeys(inputNumeroTelefono, WaitStrategy.VISIBLE, text);
        return this;
    }

    public String getNumberPhoneLabelText() {
        return numeroTelefonoLabel.getText();
    }

    public RequestCreditStep1 enterConfirmationEmail(String text) {
        sendKeys(inputConfirmarCorreo, WaitStrategy.VISIBLE, text);
        return this;
    }

    public RequestCreditStep1 enterEmail(String text) {
        sendKeys(inputCorreo, WaitStrategy.VISIBLE, text);
        return this;
    }

    public String getEmailLabelText() {
        return correoLabel.getText();
    }

    public String getConfirmEmailLabelText() {
        return confirmarCorreoLabel.getText();
    }

    public RequestCreditStep1 clickNextButton() {
        click(buttonContinuar, WaitStrategy.CLICKABLE);
        return this;
    }

    public RequestCreditStep1 selectOptionTipoHousingTypeLabel() {
        click(soyPropietarioRadioButton, WaitStrategy.CLICKABLE);
        return this;
    }

    public RequestCreditStep1 selectOptionObraLabor() {
        click(optionObraLabor, WaitStrategy.CLICKABLE);
        return this;
    }

    public RequestCreditStep1 enterMonthlyIncome(String text) {
        sendKeys(inputAmountMonth, WaitStrategy.VISIBLE, text);
        return this;
    }

    public RequestCreditStep1 openMaritalStatusDropdown() {
        click(dropdownEstadoCivil, WaitStrategy.CLICKABLE);
        return this;
    }

    public RequestCreditStep1 openEducationLevelDropdown() {
        click(dropdownNivelEstudio, WaitStrategy.CLICKABLE);
        return this;
    }

    public List<WebElement> getOptionsNivelEstudio() {
        return optionsNivelEstudio;
    }

    public List<WebElement> getOptionsEstadoCivil() {
        return optionsEstadoCivil;
    }

    public RequestCreditStep1 selectOptionMaritalStatus(String options) {
        for (WebElement item : optionsEstadoCivil) {
            if (item.getText().equals(options)) {
                click(item, WaitStrategy.CLICKABLE, item.getText());/*
                item.click();*/
                break;
            }
        }
        return this;
    }

    public RequestCreditStep1 selectOptionEducationLevel(String options) {
        for (WebElement item : optionsNivelEstudio) {
            if (item.getText().equals(options)) {
                click(item, WaitStrategy.CLICKABLE, item.getText());/*
      /*          item.click();*/
                break;
            }
        }
        return this;
    }
}
