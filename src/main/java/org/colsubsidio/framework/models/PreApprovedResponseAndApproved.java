package org.colsubsidio.framework.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreApprovedResponseAndApproved {

    @JsonProperty("tipo_id")
    private Integer tipoId;

    @JsonProperty("documento")
    private String documento;

    @JsonProperty("campanas")
    private List<CampanasBlock> campanas;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CampanasBlock {

        @JsonProperty("SUBPRODUCTO")
        private Integer subproducto;

        @JsonProperty("PRODUCTO")
        private String producto;

        @JsonProperty("TIPO_PRODUCTO")
        private String tipoProducto;

        @JsonProperty("TIPO_CAMPANA")
        private Integer tipoCampana;

        @JsonProperty("CODIGO_CAMPANA")
        private Integer codigoCampana;

        @JsonProperty("VERSION")
        private Integer version;

        // If you prefer a real date, we can map it to LocalDate with a custom format,
        // but as-is your JSON is "yyyyMMdd" string.
        @JsonProperty("FECHA_VIGENCIA")
        private String fechaVigencia;

        @JsonProperty("NOMBRE_CAMPANA")
        private String nombreCampana;

        @JsonProperty("LIBRANZA_SN")
        private String libranzaSn; // or Boolean with custom mapping if it's always "S/N" or "Y/N"

        @JsonProperty("MONTO")
        private Long monto;

        @JsonProperty("CUOTA")
        private Integer cuota;

        @JsonProperty("PLAZO")
        private Integer plazo;

        @JsonProperty("PLAN_DE_INTERES")
        private Integer planDeInteres;

        @JsonProperty("TASA")
        private Integer tasa; // if it can be decimal, change to BigDecimal

        @JsonProperty("CODIGO_DE_GARANTIA")
        private Integer codigoDeGarantia;

        @JsonProperty("ESTADO_DE_CAMPANA")
        private Integer estadoDeCampana;

        @JsonProperty("GESTION_DOCUMENTAL")
        private Integer gestionDocumental;

    }
}
