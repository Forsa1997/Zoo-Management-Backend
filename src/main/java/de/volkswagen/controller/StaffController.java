package de.volkswagen.controller;


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




}
