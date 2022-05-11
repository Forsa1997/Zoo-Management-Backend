package de.volkswagen.enclosure;


import de.volkswagen.animal.AnimalType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnclosureControllerWithMockedServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EnclosureService enclosureService;

    @Test
    void getEnclosureById_returns200OK() {
        String url = "/api/enclosure/1";

        when(enclosureService.getById(any(Long.class)))
        .thenReturn(new Enclosure());

        ResponseEntity<Enclosure> response = restTemplate.getForEntity(url, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void getEnclosureById_returns400BadRequestForInvalidParameter_String() {
        String url = "/api/enclosure/number";

        when(enclosureService.getById(any(Long.class)))
                .thenReturn(new Enclosure());

        ResponseEntity<Enclosure> response = restTemplate.getForEntity(url, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void getEnclosureById_returns_400BadRequest_forInvalidParameter_tooLong() {
        String url = "/api/enclosure/1234567890123456789012345678901234567890";

        when(enclosureService.getById(any(Long.class)))
                .thenReturn(new Enclosure());

        ResponseEntity<Enclosure> response = restTemplate.getForEntity(url, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void getEnclosureById_returns_Enclosure() {
        String url = "/api/enclosure/1";

        List<AnimalType> animalTypes = new ArrayList<>();
        animalTypes.add(AnimalType.GIRAFFE);

        Enclosure enclosure = Enclosure.builder()
                .name("name")
                .description("description")
                .build();

        when(enclosureService.getById(any(Long.class)))
                .thenReturn(enclosure);

        Enclosure resEnclosure = restTemplate.getForObject(url, Enclosure.class);

        assertThat(resEnclosure.getName()).isEqualTo(enclosure.getName());
        assertThat(resEnclosure.getDescription()).isEqualTo(enclosure.getDescription());
        assertThat(resEnclosure.getAnimalTypes()).isEqualTo(enclosure.getAnimalTypes());
        assertThat(resEnclosure.getAnimals()).isEqualTo(enclosure.getAnimals());
    }

    @Test
    void getEnclosures_returns_200OK() {
        String url = "/api/enclosure";

        List<AnimalType> animalTypes = new ArrayList<>();
        animalTypes.add(AnimalType.GIRAFFE);

        Enclosure enclosure = Enclosure.builder()
                .name("name")
                .description("description")
                .animalTypes(animalTypes)
                .build();

        List<Enclosure> enclosures = new ArrayList<>();
        enclosures.add(enclosure);

        when(enclosureService.getAll())
        .thenReturn(new EnclosureList(enclosures));

        ResponseEntity<EnclosureList> response = restTemplate.getForEntity(url, EnclosureList.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void getEnclosures_returns_200OK_withContent() {
        String url = "/api/enclosure";

        List<AnimalType> animalTypes = new ArrayList<>();
        animalTypes.add(AnimalType.GIRAFFE);

        Enclosure enclosure = Enclosure.builder()
                .name("name")
                .description("description")
                .animalTypes(animalTypes)
                .build();

        List<Enclosure> enclosures = new ArrayList<>();
        enclosures.add(enclosure);

        when(enclosureService.getAll())
                .thenReturn(new EnclosureList(enclosures));

        ResponseEntity<EnclosureList> response = restTemplate.getForEntity(url, EnclosureList.class);

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getEnclosures()).isNotNull();
        assertThat(response.getBody().getEnclosures()).hasSize(1);
    }

    @Test
    void postEnclosure_returns200OK() {
        String url = "/api/enclosure";

        Enclosure enclosure = new Enclosure();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, header);

        ResponseEntity<Enclosure> response = restTemplate.postForEntity(url,request, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void postEnclosure_returnsEntityWithNewId() {
        String url = "/api/enclosure";

        List<AnimalType> animalTypes = new ArrayList<>();
        animalTypes.add(AnimalType.GIRAFFE);

        String name = "name";
        String description = "description";

        Enclosure enclosure = Enclosure.builder()
                .name("name")
                .description("description")
                .animalTypes(animalTypes)
                .build();

        Enclosure matchEnclosure = Enclosure.builder()
                .name("name")
                .description("description")
                .animalTypes(animalTypes)
                .build();

        when(enclosureService.create(any(Enclosure.class))).thenReturn(matchEnclosure);

        HttpHeaders header = new HttpHeaders();
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, header);

        ResponseEntity<Enclosure> response = restTemplate.postForEntity(url,request, Enclosure.class);

        Enclosure resEnclosure = response.getBody();

        assertThat(resEnclosure.getName()).isEqualTo(matchEnclosure.getName());
        assertThat(resEnclosure.getDescription()).isEqualTo(matchEnclosure.getDescription());
        assertThat(resEnclosure.getAnimalTypes()).isEqualTo(matchEnclosure.getAnimalTypes());
        assertThat(resEnclosure.getAnimals()).isEqualTo(matchEnclosure.getAnimals());
        assertThat(resEnclosure.getId()).isEqualTo(matchEnclosure.getId());
    }


}
