package com.example.practice.animals;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/animals", produces = MediaTypes.HAL_JSON_VALUE)
public class AnimalController {

    @GetMapping
    public ResponseEntity getAnimalCollection() {
        Animal animal = Animal.builder().build();
        return ResponseEntity.ok(animal);
    }
}
