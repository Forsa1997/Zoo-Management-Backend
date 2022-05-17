package de.volkswagen.staff;

import de.volkswagen.enclosure.Enclosure;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public StaffList getStaffs(
    ) {
        return this.staffService.getAll();
    }

    @GetMapping("/{staffId}")
    public Staff getStaffById(
            @PathVariable Long staffId
    ) {
        return this.staffService.getById(staffId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Staff postStaff(@RequestBody Staff staff) {
        return this.staffService.create(staff);
    }

    @PatchMapping
    public Staff patchStaff(
            @RequestBody Staff staff
    ) {
        return this.staffService.update(staff);
    }

    @DeleteMapping("/{staffId}")
    public void deleteStaff(
            @PathVariable("staffId") Long staffId
    ) {
        this.staffService.deleteById(staffId);
    }

    @PostMapping("/{staffId}/enclosure/{enclosureId}")
    public Enclosure assignStaffToEnclosure(
            @PathVariable("staffId") Long staffId,
            @PathVariable("enclosureId") Long enclosureId
    ) {
        return this.staffService.assignStaffToEnclosure(staffId, enclosureId);
    }

    @DeleteMapping("/{staffId}/enclosure/{enclosureId}")
    public Enclosure deleteStaffFromEnclosure(
            @PathVariable("staffId") Long staffId,
            @PathVariable("enclosureId") Long enclosureId
    ) {

        return null;
    }
}
