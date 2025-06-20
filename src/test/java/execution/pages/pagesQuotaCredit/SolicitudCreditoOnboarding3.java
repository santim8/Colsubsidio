package execution.pages.pagesQuotaCredit;

import execution.enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class SolicitudCreditoOnboarding3 extends BasePage {

    @FindBy(xpath = "//p[text() ='Ten en cuenta lo siguiente']")
    private WebElement title;

    @FindBy(xpath = "//button[.//span[text()='Comenzar']]")
    private WebElement startButton;

    public SolicitudCreditoOnboarding3(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SolicitudCreditoOnboarding3 validateTitle() {
        getText(title, WaitStrategy.VISIBLE, "Title_Solicitud_Credito_Onboarding_3");
        return this;
    }

    public void clickOnStartButton() {
        startButton.click();
    }
}
