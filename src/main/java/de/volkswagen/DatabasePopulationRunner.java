package de.volkswagen;

import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalService;
import de.volkswagen.animal.AnimalType;
import de.volkswagen.enclosure.Enclosure;
import de.volkswagen.enclosure.EnclosureService;
import de.volkswagen.models.Cost;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Profile("!test")
@Component
public class DatabasePopulationRunner implements CommandLineRunner {

    private EnclosureService enclosureService;
    private AnimalService animalService;

    public DatabasePopulationRunner(
            EnclosureService enclosureService,
            AnimalService animalService
    ) {
        this.enclosureService = enclosureService;
        this.animalService = animalService;
    }

    @Override
    public void run(String... args) {
        enclosureService.create(Enclosure.builder()
                .name("Affenhaus")
                .description("Kleine Äffchen")
                .animalTypes(Collections.singletonList(AnimalType.MONKEY))
                .animals(Arrays.asList(
                        animalService.create(Animal.builder()
                                .name("Hugo")
                                .animalType(AnimalType.MONKEY)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Uschi")
                                .animalType(AnimalType.MONKEY)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Franko")
                                .animalType(AnimalType.MONKEY)
                                .cost(new Cost())
                                .build())
                ))
                .cost(new Cost())
                .build());

        enclosureService.create(Enclosure.builder()
                .name("Schlangenkuhle")
                .description("Nicht anfassen")
                .animalTypes(Collections.singletonList(AnimalType.SNAKE))
                .animals(Arrays.asList(
                        animalService.create(Animal.builder()
                                .name("Snekmann")
                                .animalType(AnimalType.SNAKE)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Snekfrau")
                                .animalType(AnimalType.SNAKE)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Snekperson")
                                .animalType(AnimalType.SNAKE)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Sneksnek")
                                .animalType(AnimalType.SNAKE)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Snekhelikopter")
                                .animalType(AnimalType.SNAKE)
                                .cost(new Cost())
                                .build())
                ))
                .cost(new Cost())
                .build());

        enclosureService.create(Enclosure.builder()
                .name("Savannah")
                .description("sehr warm")
                .animalTypes(Arrays.asList(AnimalType.GIRAFFE, AnimalType.HYENA, AnimalType.ZEBRA))
                .animals(Arrays.asList(
                        animalService.create(Animal.builder()
                                .name("Nico")
                                .animalType(AnimalType.GIRAFFE)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Odin")
                                .animalType(AnimalType.GIRAFFE)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Zeus")
                                .animalType(AnimalType.HYENA)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Kaan")
                                .animalType(AnimalType.ZEBRA)
                                .cost(new Cost())
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Emre")
                                .animalType(AnimalType.ZEBRA)
                                .cost(new Cost())
                                .build())
                ))
                .cost(new Cost())
                .build());
    }
}
