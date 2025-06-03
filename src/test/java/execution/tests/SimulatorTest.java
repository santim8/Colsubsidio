package execution.tests;

import execution.pagesSimulatorFreeCredit.SimulateCreditPage;
import execution.pagesSimulatorFreeCredit.SimulatorFreeCreditStep2;
import execution.pagesSimulatorFreeCredit.SimulatorFreeCreditStep3;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;

public class SimulatorTest extends BaseTest {

    @Test
    public void testSimulator() {
        BasePage basePage = new BasePage(driver);
        basePage.clickDetailsButton();
        basePage.clickOnProceedLink();
        SimulateCreditPage simulateCreditPage = new SimulateCreditPage(driver);
        Assert.assertEquals(simulateCreditPage.getTitle(), "Simula tu crédito");
        Assert.assertEquals(simulateCreditPage.getDescription(), "Explora diferentes formas de pagar tu crédito a cuotas. Recuerda que para solicitar nuestros productos debes ser afiliado.");
        simulateCreditPage.setInputRegistrationNumber("1234567890");
        simulateCreditPage.markCheckboxTermsAndConditions();
        simulateCreditPage.clickContinueButton();

        SimulatorFreeCreditStep2 simulatorFreeCreditStep2 = new SimulatorFreeCreditStep2(driver);
        wait.until(ExpectedConditions.visibilityOf(simulatorFreeCreditStep2.webElementTitle()));
        Assert.assertEquals(simulatorFreeCreditStep2.getTitle(), "Comencemos");
/*
        Assert.assertEquals(simulatorFreeCreditStep2.getQuantityLabel(), "¿Cuánto dinero necesitas?");
*/
        simulatorFreeCreditStep2.enterQuantity("7");
        simulatorFreeCreditStep2.enterAmount("10000000");
        wait.until(ExpectedConditions.visibilityOf(simulatorFreeCreditStep2.getButtonContinuar()));
        simulatorFreeCreditStep2.clickOnButtonContinuar();

        SimulatorFreeCreditStep3 simulatorFreeCreditStep3 = new SimulatorFreeCreditStep3(driver);
        Assert.assertEquals(simulatorFreeCreditStep3.getTitle(), "Resultado de tu simulación");
        Assert.assertEquals(simulatorFreeCreditStep3.getDescription(), "Cuota Mensual");
        simulatorFreeCreditStep3.clickOnMostrarDetails();
    }
}
