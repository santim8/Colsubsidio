package execution.pagesQuotaCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.baseTest.BaseTest;

public class SolicitudCreditoOnboarding1 extends BaseTest {

    private WebDriver driver;
/*    private Wait wait;*/
/*
    @FindBy(css =".MuiTypography-root.MuiTypography-p.css-1tdkqec")
*/
    @FindBy(xpath = "//button[.//p[text()='Siguiente']]")
    private WebElement nextButton;

    @FindBy(xpath = "//p[text()='¡Empieza tu solicitud digital!']")
    private WebElement title;


    public SolicitudCreditoOnboarding1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickOnButtonSiguiente(){
        nextButton.click();
    }
}
