package execution.enums;

public enum EnumsDropdowns {


    SOLTERO("Soltero(a)"),
    CASADO("Casado(a)"),
    DIVORCIDO("Divorciado(a)"),
    VIUDO("Viudo(a)"),
    UNION_LIBRE("Unión Libre"),
    PRIMARIA("Primaria"),
    BACHILLERATO("Bachillerato"),
    TECNICO("Técnico"),
    TECNOLOGO("Tecnólogo"),
    UNIVERSITARIO("Universitario");

    private String value;

    EnumsDropdowns(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
