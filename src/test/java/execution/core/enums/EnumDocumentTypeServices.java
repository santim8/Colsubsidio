package execution.core.enums;

import java.util.HashMap;

public enum EnumDocumentTypeServices {
    CEDULA_CIUDADANIA("CO1C"),
    TARJETA_IDENTIDAD("CO1T"),
    REGISTRO_CIVIL("CO1L"),
    CEDULA_EXTRANJERIA("CO1E"),
    CARNE_DIPLOMATICO("CO1D"),
    PASAPORTE("CO1P"),
    PERMISO_ESPECIAL_PERMANENCIA("CO1V"),
    PERMISO_PROTECCION_TEMPORAL("CO1W");


    static public HashMap CODE_MAP = new HashMap<>();

    static {
        CODE_MAP.put("CC", CEDULA_CIUDADANIA);
        CODE_MAP.put("TI", TARJETA_IDENTIDAD);
        CODE_MAP.put("RC", REGISTRO_CIVIL);
        CODE_MAP.put("CE", CEDULA_EXTRANJERIA);
        CODE_MAP.put("CD", CARNE_DIPLOMATICO);
        CODE_MAP.put("PA", PASAPORTE);
        CODE_MAP.put("PE", PERMISO_ESPECIAL_PERMANENCIA);
        CODE_MAP.put("PT", PERMISO_PROTECCION_TEMPORAL);
    }
    private final String value;

    EnumDocumentTypeServices(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EnumDocumentTypeServices getCode(String type){
        return (EnumDocumentTypeServices) CODE_MAP.get(type);
    }
}