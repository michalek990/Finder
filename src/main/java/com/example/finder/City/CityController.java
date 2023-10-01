package com.example.finder.City;

import com.example.finder.City.dto.CityRequest;
import com.example.finder.City.dto.CityResponse;
import com.example.finder.model.City;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest cityRequest) {
        return ResponseEntity.ok(cityService.createCity(cityRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<CityResponse> getCityByName(@PathVariable String name) {
        return ResponseEntity.ok(cityService.getCityByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> updateCity(@PathVariable Long id, @RequestBody CityRequest cityRequest) {
        return ResponseEntity.ok(cityService.updateCity(id, cityRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
