package com.example.finder.Country;

import com.example.finder.model.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public Country updateCountry(Long id, Country country) {
        Country existingCountry = countryRepository.findById(id).orElse(null);
        existingCountry.setName(country.getName());
        return countryRepository.save(existingCountry);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
