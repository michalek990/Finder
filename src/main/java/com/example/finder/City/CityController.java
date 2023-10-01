package com.example.finder.City;

import com.example.finder.model.City;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/city")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.createCity(city));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<City> getCityByName(@PathVariable String name) {
        return ResponseEntity.ok(cityService.getCityByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        return ResponseEntity.ok(cityService.updateCity(id,city));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
