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
public class ValidationResponse {

    private ResultadoValidacion resultadoValidacion;
    private List<Resultado> resultado;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResultadoValidacion {
        private String validacion;
        private String estado;
        private DatosError datosError;
        private String datosSinProcesar;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DatosError {
        private String codigoErrorValidacion;
        private String reglaErrorValidacion;
        private String descripcionErrorValidacion;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resultado {
        private int codigo;
        private String descripcion;
    }
}
