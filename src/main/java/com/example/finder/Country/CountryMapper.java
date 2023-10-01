package com.example.finder.Country;

import com.example.finder.Country.dto.CountryRequest;
import com.example.finder.Country.dto.CountryResponse;
import com.example.finder.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CountryMapper {

    @Mapping(target = "id", ignore = true)
    Country countryRequestToCountry(CountryRequest countryRequest);

    CountryResponse countryToCountryResponse(Country country);
}