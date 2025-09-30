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
public class PreApprovedResponse {
    private DataBlock data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DataBlock {
        private boolean hasCredit;
        private List<Credit> credits;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Credit {
        private String productType;
        private String amount;
    }
}
