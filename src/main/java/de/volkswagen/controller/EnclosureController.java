package de.volkswagen.controller;


import de.volkswagen.models.animal.Enclosure;
import de.volkswagen.models.staff.Staff;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnclosureController {

    @GetMapping("/enclosure")
    public List<Enclosure> getEnclosures(){

        return null;
    }

    @PutMapping("/enclosure")
    public Enclosure putEnclosure(Enclosure enclosure){

        return null;
    }

    @PatchMapping("/enclosure")
    public Enclosure patchEnclosure(Enclosure enclosure){

        return null;
    }

    @DeleteMapping("/enclosure/{enclosureId}")
    public boolean deleteEnclosure(@PathVariable("enclosureId") Long enclosureId){

        return false;
    }

    @PutMapping("/enclosure/{enclosureId}/animal/{animalId}")
    public Enclosure putAnimalIntoEnclosure(@PathVariable("enclosureId") Long enclosureId, @PathVariable("animalId") Long animalId){

        return null;
    }

    @DeleteMapping("/enclosure/{enclosureId}/animal/{animalId}")
    public Enclosure deleteAnimalFromEnclosure(@PathVariable("enclosureId") Long enclosureId, @PathVariable("animalId") Long animalId){

        return null;
    }


}
