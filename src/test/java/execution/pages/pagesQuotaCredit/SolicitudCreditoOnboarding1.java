package execution.pages.pagesQuotaCredit;

import execution.enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class SolicitudCreditoOnboarding1 extends BasePage {

    @FindBy(xpath = "//button[.//p[text()='Siguiente']]")
    private WebElement nextButton;

    @FindBy(xpath = "//p[text()='¡Empieza tu solicitud digital!']")
    private WebElement title;


    public SolicitudCreditoOnboarding1(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SolicitudCreditoOnboarding1 validateTitle() {
        getText(title, WaitStrategy.VISIBLE, "Title_Solicitud_Credito_Onboarding_1");
        return this;
    }

    public void clickNextButton() {
        click(nextButton, WaitStrategy.CLICKABLE);
    }
}
