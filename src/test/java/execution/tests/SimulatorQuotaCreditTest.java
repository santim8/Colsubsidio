package execution.tests;

import execution.enums.EnumSimulatorQuota;
import execution.enums.EnumsRouteFlows;
import execution.pagesSimulatorQuotaCredit.SimulateQuotaCredit;
import execution.pagesSimulatorQuotaCredit.SimulatorQuotaCreditStep2;
import execution.pagesSimulatorQuotaCredit.SimulatorQuotaCreditStep3;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.baseTest.BaseTest;

public class SimulatorQuotaCreditTest extends BaseTest {

    private SimulateQuotaCredit simulateQuotaCredit;
    private SimulatorQuotaCreditStep2 simulatorFreeCreditStep2;
    private SimulatorQuotaCreditStep3 simulatorQuotaCreditStep3;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        simulateQuotaCredit = new SimulateQuotaCredit(driver);
        simulatorFreeCreditStep2 = new SimulatorQuotaCreditStep2(driver);
        simulatorQuotaCreditStep3 = new SimulatorQuotaCreditStep3(driver);
        softAssert = new SoftAssert();
    }

    @Test
    @Parameters("path")
    public void testSimulatorQuotaCredit(String path) {
/*
        String path = "optionNumberAmount";
*/
        //Validate elements on the first screen
        validateElementsScreen1();

        //Validate elements on the second screen
        simulateQuotaCredit
                .setInputRegistrationNumber("1234567890")
                .markCheckboxTermsAndConditions()
                .clickOnContinueButton();
        validateElementsScreen2();

        simulatorFreeCreditStep2
                .enterAmount(EnumSimulatorQuota.AMOUNT_QUOTA.getValue());

        if (path.equals(EnumsRouteFlows.OPTION_NUMBER_AMOUNT.getValue())) {
            simulatorFreeCreditStep2
                    .clickButtonValor()
                    .enterInputAmountQuota("1000000")
                    .clickOnButtonContinuar();
        }
        else {
            simulatorFreeCreditStep2.enterQuantity(EnumSimulatorQuota.QUANTITY_QUOTA.getValue())
                    .clickOnButtonContinuar();
        }

        //Validate elements on the second screen
        validateElementsScreen3(path);
        softAssert.assertAll();
    }

    private void validateElementsScreen1() {
        softAssert.assertEquals(simulateQuotaCredit.getTitle(), "Simula tu compra");
        softAssert.assertEquals(simulateQuotaCredit.getDescription(), "Explora diferentes formas de pagar tu compra a cuotas. Recuerda que para solicitar nuestros productos debes ser afiliado.");
        softAssert.assertEquals(simulateQuotaCredit.getDocumentNumber().getText(), "Número de documento");
        softAssert.assertEquals(simulateQuotaCredit.getDocumentType().getText(), "Tipo de documento");
    }

    private void validateElementsScreen2() {
        softAssert.assertEquals(simulatorFreeCreditStep2.getTitle(), "Comencemos");
        softAssert.assertEquals(simulatorFreeCreditStep2.getInputAmountLabel(), "¿De cuánto es la compra?");
        softAssert.assertEquals(simulatorFreeCreditStep2.getInputQuantityLabel(), "¿A cuántas cuotas quieres pagar?");
        softAssert.assertEquals(simulatorFreeCreditStep2.getRestriction().getText(), "Los datos suministrados son aproximados. Esto no garantiza la aprobación del crédito.");
        softAssert.assertEquals(simulatorFreeCreditStep2.getRestriction().getText(), "Los datos suministrados son aproximados. Esto no garantiza la aprobación del crédito.");

    }

    private void validateElementsScreen3(String path) {
        softAssert.assertEquals(simulatorQuotaCreditStep3.getTitle(), "Resultado de tu simulación");

        if (path.equals(EnumsRouteFlows.OPTION_NUMBER_NQUOTAS.getValue())) {
            softAssert.assertEquals(simulatorQuotaCreditStep3.getDescription(), "Cuota Mensual");
        }

        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextValorCompra(), "Valor de la compra");
        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextNumeroCuotas(), "Número de cuotas");
        softAssert.assertEquals(simulatorQuotaCreditStep3.getSummaryText(), "Resumen de tu producto");


        simulatorQuotaCreditStep3.clickOnLinkTasaEfectivaAnual();
        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextModalTasaAnual(), "Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo. Las tasas son el resultado de un porcentaje basado en el producto y el plazo, y se abona mensualmente como parte de la cuota acordada.");

        simulatorQuotaCreditStep3
                .clickOnButtonEntendido()
                .clickOnLinkTasaNominal();

        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextModalTasaNominal(), "Es el precio que se pacta entre Colsubsidio y sus afiliados por un préstamo. Las tasas son el resultado de un porcentaje basado en el producto y el plazo, y se abona mensualmente como parte de la cuota acordada.");
        simulatorQuotaCreditStep3
                .clickOnButtonEntendido()
                .clickOnLinkSeguros();

        softAssert.assertEquals(simulatorQuotaCreditStep3.getTextModalSeguros(), "Es un respaldo financiero que cubre pérdidas inesperadas en áreas como vida, salud, o patrimonio, ayudando a pagar parte o la totalidad de los gastos asociados.");
        simulatorQuotaCreditStep3.clickOnButtonEntendido();
        softAssert.assertEquals(simulatorQuotaCreditStep3.getPercentageElement(), EnumSimulatorQuota.TASA_EFECTIVA_ANUAL.getValue());
        softAssert.assertEquals(simulatorQuotaCreditStep3.getPercentageElementTasaNominal(), EnumSimulatorQuota.TASA_NOMINAL_MV.getValue());
        softAssert.assertEquals(simulatorQuotaCreditStep3.getRestriction().getText(), "Los datos suministrados son aproximados. Esto no garantiza la aprobación del crédito.");
    }
}
