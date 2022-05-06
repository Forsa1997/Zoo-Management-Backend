package de.volkswagen.controller;


import de.volkswagen.models.animal.Enclosure;
import de.volkswagen.models.staff.Staff;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {


    @GetMapping("/staff")
    public List<Staff> getStaff(){

        return null;
    }

    @PutMapping("/staff")
    public Staff putStaff(Staff staff){

        return null;
    }

    @PatchMapping("/staff")
    public Staff patchStaff(Staff staff){

        return null;
    }

    @DeleteMapping("/staff/{staffId}")
    public boolean deleteStaff(@PathVariable("staffId") Long staffId){

       return false;
    }

    @PutMapping("/staff/{staffId}/enclosure/{enclosureId}")
    public Enclosure assignStaffToEnclosure( @PathVariable("staffId") Long staffId, @PathVariable("enclosureId") Long enclosureId){

        return null;
    }

    @PatchMapping("/staff/{staffId}/enclosure/{enclosureId}")
    public Enclosure patchStaffFromEnclosure( @PathVariable("staffId") Long staffId, @PathVariable("enclosureId") Long enclosureId){

        return null;
    }

    @DeleteMapping("/staff/{staffId}/enclosure/{enclosureId}")
    public Enclosure deleteStaffFromEnclosure( @PathVariable("staffId") Long staffId, @PathVariable("enclosureId") Long enclosureId){

        return null;
    }





}
