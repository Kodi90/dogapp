package com.fahad.dog.service;

import com.fahad.dog.domain.Breeds;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class BreedService {


    public Breeds getAllBreeds() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new ClassPathResource("breeds.json").getFile();
            return mapper.readValue(file, Breeds.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Breeds();
        }
    }
}
