package execution.core.enums;

public enum EnumSimulatorQuota {
    TASA_EFECTIVA_ANUAL("22.99%"),
    TASA_NOMINAL_MV("1.74%"),
    AMOUNT_QUOTA("10000000"),
    QUANTITY_QUOTA("7");

    private final String value;

    EnumSimulatorQuota(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
