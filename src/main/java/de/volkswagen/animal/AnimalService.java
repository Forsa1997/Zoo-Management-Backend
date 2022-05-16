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
        Long animalId = animal.getId();
        if (animalId != null && animalRepository.existsById(animalId)) {
            throw new AnimalAlreadyPresentException(animalId);
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

    public AnimalList getByIds(List<Long> animalIds) {
        List<Animal> animals = this.animalRepository.findAllById(animalIds);
        if (animals.isEmpty()) {
            throw new EmptyAnimalListException();
        }
        return new AnimalList(animals);
    }

    public Animal getById(Long animalId) {
        return animalRepository.findById(animalId)
                .orElseThrow(() -> new AnimalNotFoundException(animalId));
    }
    public Animal update(Animal animal) {
        Long animalId = animal.getId();
        if (!this.animalRepository.existsById(animalId)) {
            throw new AnimalNotFoundException(animalId);
        }
        return this.animalRepository.save(animal);
    }
    public void deleteById(Long animalId) {
        if (!this.animalRepository.existsById(animalId)) {
            throw new AnimalNotFoundException(animalId);
        }
        this.animalRepository.deleteById(animalId);
    }
}
