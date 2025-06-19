package execution.pages.pagesQuotaCredit;

import execution.enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;


public class SolicitudCreditoOnboarding2 extends BasePage {

    @FindBy(xpath = "//button[.//p[text()='Siguiente']]")
    private WebElement nextButton;

    @FindBy(xpath = "//p[text()='Conoce los requisitos']")
    private WebElement title;


    public SolicitudCreditoOnboarding2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnNExtButton() {
        nextButton.click();
    }

    public SolicitudCreditoOnboarding2 validateTitle() {
        getText(title, WaitStrategy.VISIBLE, "Title_Solicitud_Credito_Onboarding_2");
        return this;
    }
}