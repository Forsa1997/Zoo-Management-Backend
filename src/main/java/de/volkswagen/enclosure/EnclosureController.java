package de.volkswagen.enclosure;


import de.volkswagen.animal.Enclosure;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enclosure")
public class EnclosureController {

    @GetMapping
    public List<Enclosure> getEnclosures(){

        return null;
    }

    @PutMapping
    public Enclosure putEnclosure(@RequestBody Enclosure enclosure){

        return null;
    }

    @PatchMapping
    public Enclosure patchEnclosure(@RequestBody Enclosure enclosure){

        return null;
    }

    @DeleteMapping("/{enclosureId}")
    public boolean deleteEnclosure(@PathVariable("enclosureId") Long enclosureId){

        return false;
    }

    @PutMapping("/{enclosureId}/animal/{animalId}")
    public Enclosure putAnimalIntoEnclosure(@PathVariable("enclosureId") Long enclosureId, @PathVariable("animalId") Long animalId){

        return null;
    }

    @DeleteMapping("/{enclosureId}/animal/{animalId}")
    public Enclosure deleteAnimalFromEnclosure(@PathVariable("enclosureId") Long enclosureId, @PathVariable("animalId") Long animalId){

        return null;
    }


}
