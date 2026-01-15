package org.colsubsidio.framework.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class ValidateRequestResponse {
    private List<Resultado> resultado;
    private CrearCaso crearCaso;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resultado {
        // JSON has 202 (number) but you used String in the reference; keeping String for consistency
        private String codigo;
        private String descripcion;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CrearCaso {
        private String idProducto;
        private Documento documento;
        private String status;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Documento {
        private String tipo;
        private String numero;
    }
}
