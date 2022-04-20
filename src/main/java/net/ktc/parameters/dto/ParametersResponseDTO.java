package net.ktc.parameters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ParametersResponseDTO {
    private String id;
    private String name;
    private String logo;
    private String smskey;
    private String description;
}
