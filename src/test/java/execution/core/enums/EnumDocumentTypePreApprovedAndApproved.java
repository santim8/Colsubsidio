package execution.core.enums;

import java.util.HashMap;

public enum EnumDocumentTypePreApprovedAndApproved {

    CEDULA_CIUDADANIA("1"),
    CEDULA_EXTRANJERIA("2");

    final private String value;
    static public HashMap CODE_MAP = new HashMap <>();

    static {
        CODE_MAP.put("CC", CEDULA_CIUDADANIA);
        CODE_MAP.put("CE", CEDULA_EXTRANJERIA);
    }

    EnumDocumentTypePreApprovedAndApproved(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EnumDocumentTypePreApprovedAndApproved getCode(String type){
        return (EnumDocumentTypePreApprovedAndApproved) CODE_MAP.get(type);
    }
}
