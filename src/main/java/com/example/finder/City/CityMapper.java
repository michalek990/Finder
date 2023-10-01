package com.example.finder.City;

import com.example.finder.City.dto.CityRequest;
import com.example.finder.City.dto.CityResponse;
import com.example.finder.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CityMapper {

    @Mapping(target = "id", ignore = true)
    City cityRequestToCity(CityRequest cityRequest);

    CityResponse cityToCityResponse(City city);
}
