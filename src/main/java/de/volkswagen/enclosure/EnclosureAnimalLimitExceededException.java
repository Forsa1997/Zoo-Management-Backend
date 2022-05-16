package de.volkswagen.enclosure;

public class EnclosureAnimalLimitExceededException extends RuntimeException {
    public EnclosureAnimalLimitExceededException(Long enclosureId) {
        super("Enclosure with id " + enclosureId + " exceeds the animal limit of " + Enclosure.MAX_ANIMALS);
    }
}
