package de.volkswagen.stand;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stand")
public class StandController {

    @GetMapping
    public List<Stand> getStand() {

        return null;
    }

    @PutMapping
    public Stand putStand(
            @RequestBody Stand stand
    ) {

        return null;
    }

    @PatchMapping
    public Stand patchStand(
            @RequestBody Stand stand
    ) {

        return null;
    }

    @DeleteMapping("/{standId}")
    public boolean deleteStand(
            @PathVariable("standId") Long standId
    ) {

        return false;
    }

    @PutMapping("/{standId}/staff/{staffId}")
    public Stand assignStaffIntoStand(
            @PathVariable("standId") Long standId,
            @PathVariable("staffId") Long staffId
    ) {

        return null;
    }

    @DeleteMapping("/{standId}/staff/{staffId}")
    public Stand deleteStaffFromStand(
            @PathVariable("standId") Long standId,
            @PathVariable("staffId") Long staffId
    ) {

        return null;
    }

    @PatchMapping("/{standId}/staff/{staffId}")
    public Stand patchStaffFromStand(
            @PathVariable("standId") Long standId,
            @PathVariable("staffId") Long staffId
    ) {

        return null;
    }

}
