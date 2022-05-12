package de.volkswagen.animal;


import de.volkswagen.staff.Staff;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public AnimalList getAnimal(){
        return this.animalService.getAll();
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
