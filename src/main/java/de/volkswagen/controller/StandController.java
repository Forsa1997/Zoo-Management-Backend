package de.volkswagen.controller;


import de.volkswagen.models.Stand;
import de.volkswagen.models.animal.Enclosure;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StandController {

        @GetMapping("/stand")
        public List<Stand> getStand(){

                return null;
        }

        @PutMapping("/stand")
        public Stand putStand(Stand stand){

                return null;
        }

        @PatchMapping("/stand")
        public Stand patchStand(Stand stand){

                return null;
        }

        @DeleteMapping("/stand/{standId}")
        public boolean deleteStand(@PathVariable("standId") Long standId){

                return false;
        }

        @PutMapping("/stand/{standId}/staff/{staffId}")
        public Stand assignStaffIntoStand(@PathVariable("standId") Long standId, @PathVariable("staffId") Long staffId){

                return null;
        }

        @DeleteMapping("/stand/{standId}/staff/{staffId}")
        public Stand deleteStaffFromStand(@PathVariable("standId") Long standId, @PathVariable("staffId") Long staffId){

                return null;
        }

        @PatchMapping("/stand/{standId}/staff/{staffId}")
        public Stand patchStaffFromStand(@PathVariable("standId") Long standId, @PathVariable("staffId") Long staffId){

                return null;
        }

}
