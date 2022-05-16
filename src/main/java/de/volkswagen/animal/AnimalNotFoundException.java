package de.volkswagen.animal;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long animalId) {
        super("Animal with id " + animalId + " not found");
    }
}
