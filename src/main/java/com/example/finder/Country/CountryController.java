package com.example.finder.Country;

import com.example.finder.Country.dto.CountryRequest;
import com.example.finder.Country.dto.CountryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryResponse> createCountry(@RequestBody @Valid CountryRequest countryRequest) {
        return new ResponseEntity<>(countryService.createCountry(countryRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable Long id) {
        CountryResponse country = countryService.getCountryById(id);
        return ResponseEntity.ok(country);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CountryResponse>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CountryResponse> getCountryByName(@PathVariable String name) {
        CountryResponse country = countryService.getCountryByName(name);
        return ResponseEntity.ok(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> updateCountry(@PathVariable Long id, @RequestBody CountryRequest countryRequest) {
        return ResponseEntity.ok(countryService.updateCountry(id, countryRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
