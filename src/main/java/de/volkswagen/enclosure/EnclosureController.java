package de.volkswagen.enclosure;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enclosure")
public class EnclosureController {

    private EnclosureService enclosureService;

    public EnclosureController(EnclosureService enclosureService){
        this.enclosureService = enclosureService;
    }


    @GetMapping
    public List<Enclosure> getEnclosures(){

        return null;
    }

    @PostMapping
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
