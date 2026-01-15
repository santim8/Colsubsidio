package execution.core.enums;

import lombok.Getter;
import java.util.HashMap;

@Getter
public enum EnumDocumentTypeValidateRequest {

    CEDULA_CIUDADANIA("CO1C"),
    CEDULA_EXTRANJERIA("CO1E");

    final private String value;
    static public HashMap CODE_MAP = new HashMap<>();

    static {
        CODE_MAP.put("CC", CEDULA_CIUDADANIA);
        CODE_MAP.put("CE", CEDULA_EXTRANJERIA);
    }

    EnumDocumentTypeValidateRequest(String value) {
        this.value = value;
    }

    public static EnumDocumentTypeValidateRequest getCode(String type) {
        return (EnumDocumentTypeValidateRequest) CODE_MAP.get(type);
    }
}
