package execution.core.enums;

public enum EnumsRouteFlows {

    OPTION_NUMBER_NQUOTAS("optionNumberNQuotas"),
    OPTION_NUMBER_AMOUNT("optionNumberAmount");

    public final String value;

    EnumsRouteFlows(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
 }
