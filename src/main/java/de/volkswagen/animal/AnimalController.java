package de.volkswagen.animal;


import de.volkswagen.staff.Staff;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {


    @GetMapping
    public List<Animal> getAnimal(){

        return null;
    }

    @PutMapping
    public Animal putAnimal(Animal animal){

        return null;
    }

    @PatchMapping
    public Animal patchAnimal(Animal animal){

        return null;
    }

    @DeleteMapping("/{animalId}")
    public boolean deleteAnimal(@PathVariable("animalId") Long animalId){

        return false;
    }

}
