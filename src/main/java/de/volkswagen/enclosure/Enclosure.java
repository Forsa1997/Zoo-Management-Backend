package de.volkswagen.enclosure;

import de.volkswagen.animal.Animal;
import de.volkswagen.models.Cost;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Enclosure {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private List<Animal> animals;

    @Getter
    @Setter
    private Cost cost;


    public Cost getCostWithAnimals() {
        return this.animals.stream()
                .map(Animal::getCost)
                .reduce(this.cost, Cost::add);
    }


}
