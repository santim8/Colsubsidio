package execution.enums;

import org.example.Main;

import java.util.HashMap;

public enum EnumDocumentType {
    CEDULA_CIUDADANIA("2"),
    TARJETA_IDENTIDAD("4"),
    REGISTRO_CIVIL("5"),
    CEDULA_EXTRANJERIA("3"),
    CARNE_DIPLOMATICO("6"),
    PASAPORTE("7"),
    PERMISO_ESPECIAL_PERMANENCIA("8"),
    PERMISO_PROTECCION_TEMPORAL("9");


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

    EnumDocumentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EnumDocumentType getCode(String type){
        return (EnumDocumentType) CODE_MAP.get(type);
    }
}