package de.volkswagen.staff;


import de.volkswagen.animal.Enclosure;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {


    @GetMapping
    public List<Staff> getStaff(){

        return null;
    }

    @PutMapping
    public Staff putStaff(@RequestBody Staff staff){

        return null;
    }

    @PatchMapping
    public Staff patchStaff(@RequestBody Staff staff){

        return null;
    }

    @DeleteMapping("/{staffId}")
    public boolean deleteStaff(@PathVariable("staffId") Long staffId){

       return false;
    }

    @PutMapping("/{staffId}/enclosure/{enclosureId}")
    public Enclosure assignStaffToEnclosure( @PathVariable("staffId") Long staffId, @PathVariable("enclosureId") Long enclosureId){

        return null;
    }

    @PatchMapping("/{staffId}/enclosure/{enclosureId}")
    public Enclosure patchStaffFromEnclosure( @PathVariable("staffId") Long staffId, @PathVariable("enclosureId") Long enclosureId){

        return null;
    }

    @DeleteMapping("/{staffId}/enclosure/{enclosureId}")
    public Enclosure deleteStaffFromEnclosure( @PathVariable("staffId") Long staffId, @PathVariable("enclosureId") Long enclosureId){

        return null;
    }





}
