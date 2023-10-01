package com.example.finder.City;

import com.example.finder.City.dto.CityRequest;
import com.example.finder.City.dto.CityResponse;
import com.example.finder.model.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityResponse createCity(CityRequest cityRequest) {
        City city = cityMapper.cityRequestToCity(cityRequest);
        City savedCity = cityRepository.save(city);
        return cityMapper.cityToCityResponse(savedCity);
    }

    public CityResponse getCityById(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        return cityMapper.cityToCityResponse(city);
    }

    public List<CityResponse> getAllCities(){
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::cityToCityResponse)
                .collect(Collectors.toList());
    }

    public CityResponse getCityByName(String name) {
        City city = cityRepository.findByName(name);
        return cityMapper.cityToCityResponse(city);
    }

    public CityResponse updateCity(Long id, CityRequest cityRequest) {
        City existingCity = cityRepository.findById(id).orElse(null);
        existingCity.setName(cityRequest.getName());
        City updatedCity = cityRepository.save(existingCity);
        return cityMapper.cityToCityResponse(updatedCity);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
