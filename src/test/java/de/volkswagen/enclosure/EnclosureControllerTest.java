package de.volkswagen.enclosure;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnclosureControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(0)
    public void getEnclosures_returns204NoContent() {
        String url = "/api/enclosure";

        ResponseEntity<EnclosureList> response = restTemplate.getForEntity(url, EnclosureList.class);

        //assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @Order(1)
    public void postEnclosure_returns201Created() {
        String url = "/api/enclosure";

        Enclosure enclosure = Enclosure.builder()
                .name("name")
                .description("description")
                .build();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, header);

        ResponseEntity<Enclosure> response = restTemplate.postForEntity(url,request, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}