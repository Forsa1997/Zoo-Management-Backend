package de.volkswagen.animal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal create(Animal animal) {
        if (animal.getId() != null && animalRepository.existsById(animal.getId())) {
            throw new AnimalAlreadyPresentException();
        }
        return this.animalRepository.save(animal);
    }

    public AnimalList getAll() {
        List<Animal> animals = this.animalRepository.findAll();
        if (animals.isEmpty()) {
            throw new EmptyAnimalListException();
        }
        return new AnimalList(animals);
    }

    public Animal getById(Long animalId) {
        return animalRepository.findById(animalId)
                .orElseThrow(AnimalNotFoundException::new);
    }
    public Animal update(Animal animal) {
        if (!this.animalRepository.existsById(animal.getId())) {
            throw new AnimalNotFoundException();
        }
        return this.animalRepository.save(animal);
    }
    public void deleteById(Long animalId) {
        if (!this.animalRepository.existsById(animalId)) {
            throw new AnimalNotFoundException();
        }
        this.animalRepository.deleteById(animalId);
    }
}
