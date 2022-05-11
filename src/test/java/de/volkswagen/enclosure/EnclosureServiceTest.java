package de.volkswagen.enclosure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EnclosureServiceTest {

    EnclosureService enclosureService;

    @MockBean
    EnclosureRepository enclosureRepository;

    @BeforeEach
    void init() {
        enclosureService = new EnclosureService(enclosureRepository);
    }

    @Test
    public void foo() {

    }
}