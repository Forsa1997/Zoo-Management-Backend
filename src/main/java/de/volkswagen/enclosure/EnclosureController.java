package de.volkswagen.enclosure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enclosure")
public class EnclosureController {

    private EnclosureService enclosureService;

    public EnclosureController(EnclosureService enclosureService){
        this.enclosureService = enclosureService;
    }


    @GetMapping("/{enclosureId}")
    public Enclosure getEnclosureById(
            @PathVariable Long enclosureId
    ){
        return this.enclosureService.getById(enclosureId);
    }

    @GetMapping
    public EnclosureList getEnclosures(){
        return this.enclosureService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enclosure postEnclosure(
            @RequestBody Enclosure enclosure
    ){
        return enclosureService.create(enclosure);
    }

    @PatchMapping
    public Enclosure patchEnclosure(
            @RequestBody Enclosure enclosure
    ){
        return null;
    }

    @DeleteMapping("/{enclosureId}")
    public boolean deleteEnclosure(
            @PathVariable("enclosureId") Long enclosureId
    ){
        return false;
    }

    @PutMapping("/{enclosureId}/animal/{animalId}")
    public Enclosure putAnimalIntoEnclosure(
            @PathVariable("enclosureId") Long enclosureId,
            @PathVariable("animalId") Long animalId
    ){

        return null;
    }

    @DeleteMapping("/{enclosureId}/animal/{animalId}")
    public Enclosure deleteAnimalFromEnclosure(
            @PathVariable("enclosureId") Long enclosureId,
            @PathVariable("animalId") Long animalId
    ){
        return null;
    }

}
