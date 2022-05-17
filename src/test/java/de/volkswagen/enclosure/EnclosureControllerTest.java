package de.volkswagen.enclosure;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
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
        String url = "/enclosure";

        ResponseEntity<EnclosureList> response = restTemplate.getForEntity(url, EnclosureList.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @Order(1)
    public void postEnclosure_withoutId_returns201Created() {
        String url = "/enclosure";

        Enclosure enclosure = Enclosure.builder()
                .name("name")
                .description("description")
                .build();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, header);

        ResponseEntity<Enclosure> response = restTemplate.postForEntity(url, request, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @Order(2)
    public void postEnclosure_withFixedId_free_returns201Created() {
        String url = "/enclosure";

        Enclosure enclosure = Enclosure.builder()
                .id(2L)
                .name("name")
                .description("description")
                .build();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, header);

        ResponseEntity<Enclosure> response = restTemplate.postForEntity(url,request, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @Order(3)
    public void postEnclosure_withFixedId_used_returns226IMUSED() {
        String url = "/enclosure";

        Enclosure enclosure = Enclosure.builder()
                .id(2L)
                .name("name")
                .description("description")
                .build();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, header);

        ResponseEntity<Enclosure> response = restTemplate.postForEntity(url, request, Enclosure.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.IM_USED);
    }

    @Test
    @Disabled
    @Order(4)
    public void patchEnclosure_notFound() {
        String url = "http://localhost:" + port + "/api/enclosure";

        Enclosure enclosure = Enclosure.builder()
                .id(9001L)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Enclosure> request = new HttpEntity<>(enclosure, headers);

        RestTemplate restTemplate = new RestTemplate();
        HttpClient httpClient = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PATCH, request, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}