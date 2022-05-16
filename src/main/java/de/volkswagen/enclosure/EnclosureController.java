package de.volkswagen.enclosure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enclosure")
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
    public EnclosureList getEnclosures(
            @RequestBody Optional<List<Long>> enclosureIds
    ){
        return enclosureIds.isPresent()
        ? this.enclosureService.getByIds(enclosureIds.get())
        : this.enclosureService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enclosure postEnclosure(
            @RequestBody Enclosure enclosure
    ){
        return this.enclosureService.create(enclosure);
    }

    @PatchMapping
    public Enclosure patchEnclosure(
            @RequestBody Enclosure enclosure
    ){
        return this.enclosureService.update(enclosure);
    }

    @DeleteMapping("/{enclosureId}")
    public void deleteEnclosure(
            @PathVariable("enclosureId") Long enclosureId
    ){
        this.enclosureService.deleteById(enclosureId);
    }

    @PostMapping("/{enclosureId}/animal/{animalId}")
    public Enclosure putAnimalIntoEnclosure(
            @PathVariable("enclosureId") Long enclosureId,
            @PathVariable("animalId") Long animalId
    ){
        return this.enclosureService.addAnimalToEnclosure(animalId, enclosureId);
    }

    @DeleteMapping("/{enclosureId}/animal/{animalId}")
    public Enclosure deleteAnimalFromEnclosure(
            @PathVariable("enclosureId") Long enclosureId,
            @PathVariable("animalId") Long animalId
    ){
        return this.enclosureService.removeAnimalFromEnclosure(animalId, enclosureId);
    }
}
