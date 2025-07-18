package execution.pages.pagesQuotaCredit;

import execution.enums.EnumDocumentType;
import execution.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class Login extends BasePage {

    private static final String DOCUMENT_TYPE_DROPDOWN_ID = "documentTypePerson";

    @FindBy(id = "username")
    private WebElement inputIdentification;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "documentTypePerson")
    private WebElement dropdownDocumentType;

    @FindBy(xpath = "//option[@ng-reflect-ng-value = '2']")
    private WebElement optionDocumentType2;

    @FindBy(xpath = "//option[@ng-reflect-ng-value = '3']")
    private WebElement optionDocumentType3;


    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Login enterIdentification(String identificationNumber) {
        sendKeys(inputIdentification, WaitStrategy.VISIBLE, identificationNumber);
        return this;
    }

    public Login enterPassword(String password) {
        sendKeys(inputPassword, WaitStrategy.VISIBLE, password);
        return this;
    }

    public WebElement getDocumentTypeOption(String documentType) {
        return driver.findElement(
                By.xpath("//option[@ng-reflect-ng-value = '" + documentType + "']")
        );
    }

    public Login selectDocumentType(String documentType) {
        if (documentType.equals(EnumDocumentType.CEDULA_CIUDADANIA.getValue())) {
            return this;
        }
        click(dropdownDocumentType, WaitStrategy.CLICKABLE);
        click(By.xpath("//option[@ng-reflect-ng-value = '" + documentType+ "']"), WaitStrategy.CLICKABLE);
        return this;
    }
}