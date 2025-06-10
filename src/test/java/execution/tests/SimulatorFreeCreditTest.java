package execution.tests;

import execution.enums.EnumSimulatorQuota;
import execution.enums.EnumsSimulatorFreeCredit;
import execution.pagesSimulatorFreeCredit.SimulateCreditPage;
import execution.pagesSimulatorFreeCredit.SimulatorFreeCreditStep2;
import execution.pagesSimulatorFreeCredit.SimulatorFreeCreditStep3;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;

public class SimulatorFreeCreditTest extends BaseTest {

    /*@Test
    public void testSimulator() {
        SimulateCreditPage simulateCreditPage = new SimulateCreditPage(driver);
        SimulatorFreeCreditStep2 simulatorFreeCreditStep2 = new SimulatorFreeCreditStep2(driver);
        SimulatorFreeCreditStep3 simulatorFreeCreditStep3 = new SimulatorFreeCreditStep3(driver);


        SoftAssert softAssert = new SoftAssert();

        BasePage basePage = new BasePage(driver)
                .clickDetailsButton()
                .clickOnProceedLink();

   *//*     basePage.clickDetailsButton();
        basePage.clickOnProceedLink();*//*
        Assert.assertEquals(simulateCreditPage.getTitle(), "Simula tu crédito");
        Assert.assertEquals(simulateCreditPage.getDescription(), "Explora diferentes formas de pagar tu crédito a cuotas. Recuerda que para solicitar nuestros productos debes ser afiliado.");
        simulateCreditPage.setInputRegistrationNumber("1234567890");

        simulateCreditPage
                .markCheckboxTermsAndConditions()
                .clickOnContinueButton();

        wait.until(ExpectedConditions.visibilityOf(simulatorFreeCreditStep2.webElementTitle()));
        softAssert.assertEquals(simulatorFreeCreditStep2.getTitle(), "Comencemos");

        simulatorFreeCreditStep2
                .enterQuantity("7")
                .enterAmount("10000000");
*//*
        wait.until(ExpectedConditions.visibilityOf(simulatorFreeCreditStep2.getButtonContinuar()));
*//*
        simulatorFreeCreditStep2.clickOnButtonContinuar();

        softAssert.assertEquals(simulatorFreeCreditStep3.getTitle(), "Resultado de tu simulación");
        softAssert.assertEquals(simulatorFreeCreditStep3.getDescription(), "Cuota Mensual");

        simulatorFreeCreditStep3
                .clickOnMostrarDetails()
                .clickOnLinkTasaEfectivaAnual();

        softAssert.assertEquals(simulatorFreeCreditStep3.getTextModalTasaAnual(), "Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo. Las tasas son el resultado de un porcentaje basado en el producto y el plazo, y se abona mensualmente como parte de la cuota acordada.");

        simulatorFreeCreditStep3
                .clickOnButtonEntendido()
                .clickOnLinkTasaNominal();

        softAssert.assertEquals(simulatorFreeCreditStep3.getTextModalTasaNominal(), "Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo. Las tasas son el resultado de un porcentaje basado en el producto y el plazo, y se abona mensualmente como parte de la cuota acordada.");
        simulatorFreeCreditStep3
                .clickOnButtonEntendido()
                .clickOnLinkSeguros();

        softAssert.assertEquals(simulatorFreeCreditStep3.getTextModalSeguros(), "Es un respaldo financiero que cubre pérdidas inesperadas en áreas como vida, salud, o patrimonio, ayudando a pagar parte o la totalidad de los gastos asociados.");
        simulatorFreeCreditStep3.clickOnButtonEntendido();
        softAssert.assertEquals(simulatorFreeCreditStep3.getPercentageElement(), EnumsSimulatorFreeCredit.TASA_EFECTIVA_ANUAL.getValue());
        softAssert.assertEquals(simulatorFreeCreditStep3.getPercentageElementTasaNominal(), EnumsSimulatorFreeCredit.TASA_NOMINAL_MV.getValue());


        softAssert.assertAll();
    }*/
}
