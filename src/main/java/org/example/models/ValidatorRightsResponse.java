package org.example.models;

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
public class ValidatorRightsResponse {

    private int estado;
    private String mensaje;
    private List<DataItem> data;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataItem {
        private Afiliado afiliado;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Afiliado {
        private String bp;
        private String numeroDocumento;
        private String tipoDocumento;
        private String primerNombre;
        // add more fields if API returns them (e.g., segundoNombre, apellidos, etc.)
    }
}
