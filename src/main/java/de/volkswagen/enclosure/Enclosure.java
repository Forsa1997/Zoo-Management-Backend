package de.volkswagen.enclosure;

import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalType;
import de.volkswagen.models.Cost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Enclosure {

    public Enclosure() {
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private List<AnimalType> animalTypes;

    @Getter
    @Setter
    private List<Animal> animals;

    @Getter
    @Setter
    private Cost cost;

    public Cost getCostWithAnimals() {
        if(this.cost == null){
            this.cost = new Cost();
        }
        if (this.animals == null){
            return this.cost;
        }
        return this.animals.stream()
                .map(Animal::getCost)
                .reduce(this.cost, Cost::add);
    }

}
