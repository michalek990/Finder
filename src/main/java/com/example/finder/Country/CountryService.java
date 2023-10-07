package com.example.finder.Country;

import com.example.finder.Country.dto.CountryRequest;
import com.example.finder.Country.dto.CountryResponse;
import com.example.finder.Exceptions.NotFoundException;
import com.example.finder.model.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryResponse createCountry(CountryRequest countryRequest) {
        Country country = countryMapper.countryRequestToCountry(countryRequest);
        Country savedCountry = countryRepository.save(country);
        return countryMapper.countryToCountryResponse(savedCountry);
    }

    public CountryResponse getCountryById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country not found"));
        return countryMapper.countryToCountryResponse(country);
    }

    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::countryToCountryResponse)
                .collect(Collectors.toList());
    }

    public CountryResponse getCountryByName(String name) {
        Country country = countryRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Country not found"));
        return countryMapper.countryToCountryResponse(country);
    }

    public CountryResponse updateCountry(Long id, CountryRequest countryRequest) {
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country with id: %d not found".formatted(id)));
        existingCountry.setName(countryRequest.getName());
        Country updatedCountry = countryRepository.save(existingCountry);
        return countryMapper.countryToCountryResponse(updatedCountry);
    }

    public void deleteCountry(Long id) {
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country with id: %d not found".formatted(id)));
        countryRepository.deleteById(id);
    }
}
