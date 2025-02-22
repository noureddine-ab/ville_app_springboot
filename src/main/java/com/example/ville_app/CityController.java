package com.example.ville_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    // GET /cities : Récupérer la liste des villes
    @GetMapping
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // POST /cities : Ajouter une nouvelle ville
    @PostMapping
    public City addCity(@RequestBody City city) {
        return cityRepository.save(city);
    }

    // DELETE /cities/:id : Supprimer une ville
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        if (!cityRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cityRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}