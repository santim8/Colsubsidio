package execution.pages.pagesQuotaCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class SolicitudCreditoOnboarding3 extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//p[text() ='Ten en cuenta lo siguiente']")
    private WebElement title;

    @FindBy(xpath = "//button[.//span[text()='Comenzar']]")
    private WebElement startButton;

    public SolicitudCreditoOnboarding3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickOnStartButton() {
        startButton.click();
    }
}
