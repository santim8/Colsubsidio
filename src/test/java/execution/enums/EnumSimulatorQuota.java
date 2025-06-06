package execution.enums;

public enum EnumSimulatorQuota {
    TASA_EFECTIVA_ANUAL("22.99%"),
    TASA_NOMINAL_MV("1.74%");

    private final String value;

    EnumSimulatorQuota(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
