package de.volkswagen.animal;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(
            AnimalService animalService
    ) {
        this.animalService = animalService;
    }

    @GetMapping
    public AnimalList getAnimal(
            @RequestBody Optional<List<Long>> animalIds
    ){
        return animalIds.isPresent()
            ? this.animalService.getByIds(animalIds.get())
            : this.animalService.getAll();
    }

    @PostMapping
    public Animal postAnimal(
            @RequestBody Animal animal
    ){
        return this.animalService.create(animal);
    }

    @PatchMapping
    public Animal patchAnimal(
            @RequestBody Animal animal
    ){
        return this.animalService.update(animal);
    }

    @DeleteMapping("/{animalId}")
    public void deleteAnimal(
            @PathVariable("animalId") Long animalId
    ) {
        this.animalService.deleteById(animalId);
    }
}