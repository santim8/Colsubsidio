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
        private String segundoNombre;
        private String primerApellido;
        private String segundoApellido;
        private String fechaNacimiento;
        private String fechaActualizacion;
        private String edad;
        private String genero;
        private String estadoCivil;
        private String personasACargo;
        private String nivelEducativo;
        private String telefono;
        private String motivoRetiro;
        private String estado;
        private String correoElectronico;
    }
}
