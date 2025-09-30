package execution.core.enums;

public enum EnumsSimulatorFreeCredit {

    TASA_EFECTIVA_ANUAL("25.3%"),
    TASA_NOMINAL_MV("1.9%");

    private final String value;

    EnumsSimulatorFreeCredit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
