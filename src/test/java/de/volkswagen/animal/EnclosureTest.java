package de.volkswagen.animal;


import de.volkswagen.enclosure.Enclosure;
import de.volkswagen.models.Cost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnclosureTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void foobar() {

        String url = "http://localhost:" + port + "/api/enclosure";

        List<AnimalType> animalTypes = new ArrayList<>();

        animalTypes.add(AnimalType.GIRAFFE);

        Enclosure enclosure = new Enclosure(
                -1l,
                "name",
                "description",
                animalTypes,
                new ArrayList<>()
        );
        HttpHeaders header = new HttpHeaders();
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, header);

        header.add("Content-Type", MediaType.APPLICATION_JSON.toString());

        ResponseEntity<Enclosure> response = restTemplate.postForEntity(url,request, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Enclosure resEnclosure = response.getBody();

        System.out.println(resEnclosure.getId());

        assertThat(resEnclosure.getName()).isEqualTo(enclosure.getName());
        assertThat(resEnclosure.getDescription()).isEqualTo(enclosure.getDescription());
        assertThat(resEnclosure.getAnimalTypes()).isEqualTo(enclosure.getAnimalTypes());
        assertThat(resEnclosure.getAnimals()).isEqualTo(enclosure.getAnimals());
    }


}
