package com.example.finder.Exceptions.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvalidParameterResponse {
    @NotBlank
    private String parameter;

    @NotBlank
    private String message;
}
