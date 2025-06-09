package execution.tests;

import execution.enums.EnumSimulatorQuota;
import execution.pagesSimulatorQuotaCredit.SimulateQuotaCredit;
import execution.pagesSimulatorQuotaCredit.SimulatorQuotaCreditStep2;
import execution.pagesSimulatorQuotaCredit.SimulatorQuotaCreditStep3;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.baseTest.BaseTest;

public class SimulatorQuotaCreditTest extends BaseTest {

    @Test
    public void testSimulatorQuotaCredit() {
        SoftAssert softAssert = new SoftAssert();

        SimulateQuotaCredit simulateQuotaCredit = new SimulateQuotaCredit(driver);
        softAssert.assertEquals(simulateQuotaCredit.getTitle(), "Simula tu compra");
        softAssert.assertEquals(simulateQuotaCredit.getDescription(), "Explora diferentes formas de pagar tu compra a cuotas. Recuerda que para solicitar nuestros productos debes ser afiliado.");

        simulateQuotaCredit.setInputRegistrationNumber("1234567890");
        simulateQuotaCredit.markCheckboxTermsAndConditions();
        simulateQuotaCredit.clickContinueButton();

        SimulatorQuotaCreditStep2 simulatorFreeCreditStep2 = new SimulatorQuotaCreditStep2(driver);
        wait.until(ExpectedConditions.visibilityOf(simulatorFreeCreditStep2.webElementTitle()));
        softAssert.assertEquals(simulatorFreeCreditStep2.getTitle(), "Comencemos");

        simulatorFreeCreditStep2.enterQuantity(EnumSimulatorQuota.AMOUNT_QUOTA.getValue());
        simulatorFreeCreditStep2.enterAmount(EnumSimulatorQuota.QUANTITY_QUOTA.getValue());
        wait.until(ExpectedConditions.visibilityOf(simulatorFreeCreditStep2.getButtonContinuar()));
        simulatorFreeCreditStep2.clickOnButtonContinuar();

        SimulatorQuotaCreditStep3 simulatorQuotaCreditStep3 = new SimulatorQuotaCreditStep3(driver);
        wait.until(ExpectedConditions.visibilityOf(simulatorQuotaCreditStep3.getWebElementTitle()));
        softAssert.assertEquals(simulatorQuotaCreditStep3.getTitle(), "Resultado de tu simulación");
        Assert.assertEquals(simulatorQuotaCreditStep3.getDescription(), "Cuota Mensual");

        simulatorQuotaCreditStep3.clickOnLinkTasaEfectivaAnual();
        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextModalTasaAnual(), "Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo. Las tasas son el resultado de un porcentaje basado en el producto y el plazo, y se abona mensualmente como parte de la cuota acordada.");
        simulatorQuotaCreditStep3.clickOnButtonEntendido();

        simulatorQuotaCreditStep3.clickOnLinkTasaNominal();
        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextModalTasaNominal(), "Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo. Las tasas son el resultado de un porcentaje basado en el producto y el plazo, y se abona mensualmente como parte de la cuota acordada.");
        simulatorQuotaCreditStep3.clickOnButtonEntendido();


        simulatorQuotaCreditStep3.clickOnLinkSeguros();
        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextModalSeguros(), "Es un respaldo financiero que cubre pérdidas inesperadas en áreas como vida, salud, o patrimonio, ayudando a pagar parte o la totalidad de los gastos asociados.");
        simulatorQuotaCreditStep3.clickOnButtonEntendido();

        softAssert.assertEquals(simulatorQuotaCreditStep3.getPercentageElement(), EnumSimulatorQuota.TASA_EFECTIVA_ANUAL.getValue());
        softAssert.assertEquals(simulatorQuotaCreditStep3.getPercentageElementTasaNominal(), EnumSimulatorQuota.TASA_NOMINAL_MV.getValue());

        String percentage = simulatorQuotaCreditStep3.getPercentageElement();
        String percentage2 = simulatorQuotaCreditStep3.getPercentageElementTasaNominal();

        softAssert.assertTrue(simulatorQuotaCreditStep3.getTextXpathNodeP(EnumSimulatorQuota.AMOUNT_QUOTA.getValue()+ " meses"));

        System.out.println("Percentage Element: " + percentage);  // This prints the value
        System.out.println("Percentage Element: " + percentage2);
        softAssert.assertAll();


    }
}
