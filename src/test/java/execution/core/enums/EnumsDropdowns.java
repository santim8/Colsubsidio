package execution.core.enums;

/**
 * EnumsDropdowns represents a collection of enumeration values used
 * for dropdown options in the application. Each enumeration value
 * corresponds to a specific category or type, with an associated string value
 * for display or identification purposes.
 *
 * The enum values include:
 * - SOLTERO: Represents the "Single" marital status.
 * - CASADO: Represents the "Married" marital status.
 * - DIVORCIDO: Represents the "Divorced" marital status.
 * - VIUDO: Represents the "Widowed" marital status.
 * - UNION_LIBRE: Represents the "Common-law union" marital status.
 * - PRIMARIA: Represents the "Primary education" academic level.
 * - BACHILLERATO: Represents the "High school education" academic level.
 * - TECNICO: Represents the "Technical education" academic level.
 * - TECNOLOGO: Represents the "Technologist education" academic level.
 * - UNIVERSITARIO: Represents the "University education" academic level.
 *
 * Each enumeration value is associated with a string that can be retrieved
 * using the {@link #getValue()} method.
 */
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
