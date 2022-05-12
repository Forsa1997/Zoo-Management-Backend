package de.volkswagen;

import de.volkswagen.animal.AnimalType;
import de.volkswagen.enclosure.Enclosure;
import de.volkswagen.enclosure.EnclosureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(
		EnclosureService enclosureService
	) {
		return args -> {
			enclosureService.create(Enclosure.builder()
					.name("Affenhaus")
					.description("Kleine Äffchen")
					.animalTypes(Arrays.asList(AnimalType.MONKEY))
					.build());
			enclosureService.create(Enclosure.builder()
					.name("Schlangenkuhle")
					.description("Nicht anfassen")
					.animalTypes(Arrays.asList(AnimalType.SNAKE))
					.build());
			enclosureService.create(Enclosure.builder()
					.name("Savannah")
					.description("sehr warm")
					.animalTypes(Arrays.asList(AnimalType.GIRAFFE, AnimalType.HYENA, AnimalType.ZEBRA))
					.build());
		};
	}
}
