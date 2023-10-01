package com.example.finder.City;

import com.example.finder.model.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }

    public City updateCity(Long id, City city) {
        City existingCity = cityRepository.findById(id).orElse(null);
        existingCity.setName(city.getName());
        return cityRepository.save(existingCity);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
