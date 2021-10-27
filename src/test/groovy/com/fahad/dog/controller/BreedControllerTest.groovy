package com.fahad.dog.controller

import com.fahad.dog.domain.Breeds
import com.fahad.dog.service.BreedService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource
import spock.lang.Specification

class BreedControllerTest extends Specification {

    def 'Get All Breeds Test'() {
        given:
        BreedService breedService = Mock(BreedService.class)
        BreedController breedController = new BreedController(breedService)

        breedService.getAllBreeds() >> {
            ObjectMapper mapper = new ObjectMapper();
            File file = new ClassPathResource("breeds.json").getFile();
            return mapper.readValue(file, Breeds.class);
        }

        when:
        Breeds breeds = breedController.getAllBreeds()

        then:
        breeds.getWolfhound().get(0) == "irish";
    }
}
