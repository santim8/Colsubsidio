package execution.tests;

import execution.enums.EnumSimulatorQuota;
import execution.pages.pagesSimulatorFreeCredit.SimulateFreeCreditPage;
import execution.pages.pagesSimulatorFreeCredit.SimulatorFreeCreditStep2;
import execution.pages.pagesSimulatorFreeCredit.SimulatorFreeCreditStep3;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.basePage.BasePage;
import utils.baseTest.BaseTest;

public class SimulatorFreeCreditTest extends BaseTest {
    private SimulateFreeCreditPage simulateFreeCreditPage;
    private SimulatorFreeCreditStep2 simulatorFreeCreditStep2;
    private SimulatorFreeCreditStep3 simulatorFreeCreditStep3;
    private SoftAssert softAssert;
    private BasePage basePage;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        basePage = new BasePage(driver);
        simulateFreeCreditPage = new SimulateFreeCreditPage(driver);
        simulatorFreeCreditStep2 = new SimulatorFreeCreditStep2(driver);
        simulatorFreeCreditStep3 = new SimulatorFreeCreditStep3(driver);
    }

    @Test
    public void testSimulator() {
        //Validate elements on the first screen
        basePage
                .clickDetailsButton()
                .clickOnProceedLink();
        validateElementsScreen1();

        //Validate elements on the second screen
        simulateFreeCreditPage
                .setInputRegistrationNumber("1234567890")
                .markCheckboxTermsAndConditions()
                .clickOnContinueButton();
        validateElementsScreen2();


        simulatorFreeCreditStep2
                .enterQuantity("7")
                .enterAmount("10000000")
                .clickOnButtonContinuar();

        //Validate elements on the third screen
        simulatorFreeCreditStep3
                .clickOnMostrarDetails();
        validateElementsScreen3();

    }

    public void validateElementsScreen1(){
        Assert.assertEquals(simulateFreeCreditPage.getTitle(), "Simula tu crédito");
        Assert.assertEquals(simulateFreeCreditPage.getDescription(), "Explora diferentes formas de pagar tu crédito a cuotas. Recuerda que para solicitar nuestros productos debes ser afiliado.");
    }


    private void validateElementsScreen2() {
        softAssert.assertEquals(simulatorFreeCreditStep2.getTitle(), "Comencemos");
        softAssert.assertEquals(simulatorFreeCreditStep2.getInputAmountLabel(), "¿De cuánto es la compra?");
        softAssert.assertEquals(simulatorFreeCreditStep2.getInputQuantityLabel(), "¿A cuántas cuotas quieres pagar?");
        softAssert.assertEquals(simulatorFreeCreditStep2.getRestriction().getText(), "Los datos suministrados son aproximados. Esto no garantiza la aprobación del crédito.");
        softAssert.assertEquals(simulatorFreeCreditStep2.getRestriction().getText(), "Los datos suministrados son aproximados. Esto no garantiza la aprobación del crédito.");
    }

    private void validateElementsScreen3() {
        softAssert.assertEquals(simulatorFreeCreditStep3.getTitle(), "Resultado de tu simulación");
        softAssert.assertEquals(simulatorFreeCreditStep3.getDescription(), "Cuota Mensual");
        softAssert.assertEquals(simulatorFreeCreditStep3.getTextNumeroCuotas(), "Número de cuotas");
        softAssert.assertEquals(simulatorFreeCreditStep3.getSummaryText(), "Resumen de tu producto");


        simulatorFreeCreditStep3.clickOnLinkTasaEfectivaAnual();
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
        softAssert.assertEquals(simulatorFreeCreditStep3.getPercentageElement(), EnumSimulatorQuota.TASA_EFECTIVA_ANUAL.getValue());
        softAssert.assertEquals(simulatorFreeCreditStep3.getPercentageElementTasaNominal(), EnumSimulatorQuota.TASA_NOMINAL_MV.getValue());
        softAssert.assertEquals(simulatorFreeCreditStep3.getRestriction().getText(), "Los datos suministrados son aproximados. Esto no garantiza la aprobación del crédito.");
    }
}
