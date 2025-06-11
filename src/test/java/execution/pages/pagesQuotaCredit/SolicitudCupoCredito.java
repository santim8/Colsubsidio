package execution.pages.pagesQuotaCredit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SolicitudCupoCredito {
/*    @FindBy(className = "MuiTypography-root MuiTypography-p css-1mno1l2")
    private WebElement nextButton;*/
/*
    @FindBy(xpath = "//button[.//p[text()='Siguiente']]")
*/
    @FindBy(xpath = "//button[.//p[text()='Siguiente']]")
    private WebElement nextButton;

    @FindBy(xpath = "//p[text()='¡Empieza tu solicitud digital!']")
    private WebElement title;

    @FindBy(xpath = "//p[text()='Cupo de Crédito en tu Tarjeta de Afiliación']")
    private WebElement cupoDeCreditoText;

 /*   @FindBy(className = "MuiTypography-root MuiTypography-p css-1lbiqbb")
    private WebElement title;*/
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    public SolicitudCupoCredito(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickNextButton() {
        WebElement siguienteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//p[text()='Siguiente']]")));
        siguienteButton.click();
    }

    public WebElement getTitle() {
        return wait.until(ExpectedConditions.visibilityOf(title));
    }

    public WebElement getCupoDeCreditoText() {
        return wait.until(ExpectedConditions.visibilityOf(cupoDeCreditoText));
    }
}
