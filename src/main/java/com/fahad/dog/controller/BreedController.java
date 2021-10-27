package com.fahad.dog.controller;

import com.fahad.dog.domain.Breeds;
import com.fahad.dog.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/breeds")
@RequiredArgsConstructor
public class BreedController {

    private final BreedService breedService;


    @GetMapping(path = "/list/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Breeds> getAllBreeds() {
        return ResponseEntity.status(HttpStatus.OK).body(breedService.getAllBreeds());
    }

}
