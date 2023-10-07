package com.example.finder.Country.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryRequest {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s'-]+$", message = "Country name must start with upper case")
    private String name;
}
