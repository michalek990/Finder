package com.example.finder.Country;

import com.example.finder.model.Country;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok(countryService.createCountry(country));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable String name) {
        return ResponseEntity.ok(countryService.getCountryByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
        return ResponseEntity.ok(countryService.updateCountry(id,country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
