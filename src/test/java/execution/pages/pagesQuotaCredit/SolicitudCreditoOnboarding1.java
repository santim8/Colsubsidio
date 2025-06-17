package execution.pages.pagesQuotaCredit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    public void clickOnButtonSiguiente() {
        nextButton.click();
    }
}
