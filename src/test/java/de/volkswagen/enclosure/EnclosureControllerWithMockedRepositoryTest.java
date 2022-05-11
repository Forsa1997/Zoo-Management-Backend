package de.volkswagen.enclosure;


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
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnclosureControllerWithMockedRepositoryTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EnclosureRepository enclosureRepository;

    @Test
    void getEnclosureById_returns404NotFound() {
        String url = "/api/enclosure/1";

        when(enclosureRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());

        ResponseEntity<Enclosure> response = restTemplate.getForEntity(url, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void getEnclosures_returns_204NoContent() {
        String url = "/api/enclosure";

        when(enclosureRepository.findAll())
                .thenReturn(new ArrayList<>());

        ResponseEntity<EnclosureList> response = restTemplate.getForEntity(url, EnclosureList.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
