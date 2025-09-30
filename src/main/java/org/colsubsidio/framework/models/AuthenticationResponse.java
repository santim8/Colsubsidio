package org.colsubsidio.framework.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class AuthenticationResponse {

    private List<Resultado> resultado;
    private List<ObtenerToken> obtenerToken;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resultado {
        private String codigo;
        private String descripcion;
    }


    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObtenerToken {
        private String token;
    }
}
