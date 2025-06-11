package execution.pages.pagesQuotaCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class Login extends BasePage {

    @FindBy(id = "username")
    private WebElement inputIdentification;

    @FindBy(id = "password")
    private WebElement inputPassword;

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Login enterIdentification(String identificationNumber){
        inputIdentification.sendKeys(identificationNumber);
        return this;
    }

    public Login enterPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

}