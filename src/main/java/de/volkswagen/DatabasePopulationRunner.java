package de.volkswagen;

import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalService;
import de.volkswagen.animal.AnimalType;
import de.volkswagen.enclosure.Enclosure;
import de.volkswagen.enclosure.EnclosureService;
import de.volkswagen.staff.Staff;
import de.volkswagen.staff.StaffService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Profile("!test")
@Component
public class DatabasePopulationRunner implements CommandLineRunner {

    private EnclosureService enclosureService;
    private AnimalService animalService;
    private StaffService staffService;

    public DatabasePopulationRunner(
            EnclosureService enclosureService,
            AnimalService animalService,
            StaffService staffService
    ) {
        this.enclosureService = enclosureService;
        this.animalService = animalService;
        this.staffService = staffService;
    }

    @Override
    public void run(String... args) {
        Enclosure enclosure1 = enclosureService.create(Enclosure.builder()
                .name("Affenhaus")
                .description("Kleine Äffchen")
                .animalTypes(Collections.singletonList(AnimalType.MONKEY))
                .animals(Arrays.asList(
                        animalService.create(Animal.builder()
                                .name("Hugo")
                                .animalType(AnimalType.MONKEY)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Uschi")
                                .animalType(AnimalType.MONKEY)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Franko")
                                .animalType(AnimalType.MONKEY)
                                .build())
                ))
                .staff(Collections.singletonList(staffService.create(Staff.builder().firstName("Affenklaus").build())))
                .build());

        enclosureService.create(Enclosure.builder()
                .name("Schlangenkuhle")
                .description("Nicht anfassen")
                .animalTypes(Collections.singletonList(AnimalType.SNAKE))
                .animals(Arrays.asList(
                        animalService.create(Animal.builder()
                                .name("Snekmann")
                                .animalType(AnimalType.SNAKE)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Snekfrau")
                                .animalType(AnimalType.SNAKE)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Snekperson")
                                .animalType(AnimalType.SNAKE)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Sneksnek")
                                .animalType(AnimalType.SNAKE)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Snekhelikopter")
                                .animalType(AnimalType.SNAKE)
                                .build())
                ))
                .build());

        enclosureService.create(Enclosure.builder()
                .name("Savannah")
                .description("sehr warm")
                .animalTypes(Arrays.asList(AnimalType.GIRAFFE, AnimalType.HYENA, AnimalType.ZEBRA))
                .animals(Arrays.asList(
                        animalService.create(Animal.builder()
                                .name("Nico")
                                .animalType(AnimalType.GIRAFFE)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Odin")
                                .animalType(AnimalType.GIRAFFE)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Zeus")
                                .animalType(AnimalType.HYENA)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Kaan")
                                .animalType(AnimalType.ZEBRA)
                                .build()),
                        animalService.create(Animal.builder()
                                .name("Emre")
                                .animalType(AnimalType.ZEBRA)
                                .build())
                ))
                .build());
    }
}
