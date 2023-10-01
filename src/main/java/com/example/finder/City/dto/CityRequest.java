package com.example.finder.City.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CityRequest {
    private String name;
    private Long countryId;
}
