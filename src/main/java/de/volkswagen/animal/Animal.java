package de.volkswagen.animal;

import de.volkswagen.models.Cost;

public class Animal {


    private String name;
    private AnimalType animalType;
    private Cost cost;


    public Cost getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }
}
