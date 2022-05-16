package de.volkswagen.enclosure;


import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalAlreadyPresentException;
import de.volkswagen.animal.AnimalNotFoundException;
import de.volkswagen.animal.AnimalService;
import org.jboss.jandex.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class EnclosureService {
    private EnclosureRepository enclosureRepository;
    private AnimalService animalService;

    public EnclosureService(
            EnclosureRepository enclosureRepository,
            AnimalService animalService
    ){
        this.enclosureRepository = enclosureRepository;
        this.animalService = animalService;
    }

    public Enclosure create(Enclosure enclosure) {
        if (enclosure.getId() != null && this.enclosureRepository.existsById(enclosure.getId())) {
            throw new EnclosureAlreadyPresentException();
        }
        return enclosureRepository.save(enclosure);
    }

    public EnclosureList getAll() {
        List<Enclosure> enclosures = this.enclosureRepository.findAll();
        if (enclosures.isEmpty()) {
            throw new EmptyEnclosureListException();
        }
        return new EnclosureList(enclosures);
    }

    public EnclosureList getByIds(
            List<Long> enclosureIds
    ) {
        List<Enclosure> enclosures = this.enclosureRepository.findAllById(enclosureIds);
        if (enclosures.isEmpty()) {
            throw new EmptyEnclosureListException();
        }
        return new EnclosureList(enclosures);
    }

    public Enclosure getById(Long enclosureId) {
        return enclosureRepository.findById(enclosureId)
            .orElseThrow(() -> new EnclosureNotFoundException(enclosureId));
    }

    public Enclosure update(
            Enclosure enclosure
    ) {
        if (!this.enclosureRepository.existsById(enclosure.getId())) {
            throw new EnclosureNotFoundException(enclosure.getId());
        }
        return this.enclosureRepository.save(enclosure);
    }

    public void deleteById(
            Long enclosureId
    ) {
        if(!this.enclosureRepository.existsById(enclosureId)) {
            throw new EnclosureNotFoundException(enclosureId);
        }
        this.enclosureRepository.deleteById(enclosureId);
    }

    public Enclosure addAnimalToEnclosure(
            Long animalId,
            Long enclosureId
    ) {
        Animal animal = this.animalService.getById(animalId);
        Enclosure enclosure = this.enclosureRepository
            .findById(enclosureId).orElseThrow(() -> new EnclosureNotFoundException(enclosureId));
        if (animal == null) {
            throw new AnimalNotFoundException(animalId);
        }
        if (enclosure.getAnimals().contains(animal)) {
            throw new AnimalAlreadyPresentException(animalId);
        }
        if (enclosure.getAnimals().size() >= Enclosure.MAX_ANIMALS) {
            throw new EnclosureAnimalLimitExceededException(enclosureId);
        }
        enclosure.getAnimals().add(animal);
        return enclosureRepository.save(enclosure);
    }

    public Enclosure removeAnimalFromEnclosure(
            Long animalId,
            Long enclosureId
    ) {
        Animal animal = this.animalService.getById(animalId);
        Enclosure enclosure = this.enclosureRepository
            .findById(enclosureId).orElseThrow(() -> new EnclosureNotFoundException(enclosureId));
        if (animal == null) {
            throw new AnimalNotFoundException(animalId);
        }
        if (!enclosure.getAnimals().remove(animal)) {
            throw new AnimalNotFoundException(animalId);
        }
        return this.enclosureRepository.save(enclosure);
    }
}
