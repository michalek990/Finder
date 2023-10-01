package com.example.finder.City.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityResponse {
    private Long id;
    private String name;
    private Long countryId;
}
