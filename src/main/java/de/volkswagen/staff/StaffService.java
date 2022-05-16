package de.volkswagen.staff;


import de.volkswagen.enclosure.Enclosure;
import de.volkswagen.enclosure.EnclosureService;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    private StaffRepository staffRepository;
    private EnclosureService enclosureService;

    public StaffService(StaffRepository staffRepository, EnclosureService enclosureService) {
        this.staffRepository = staffRepository;
        this.enclosureService = enclosureService;
    }

    public Staff getById(Long staffId) {
        return staffRepository.findById(staffId)
                .orElseThrow(() -> new StaffNotFoundException(staffId));
    }

    public StaffList getAll() {
        return new StaffList(staffRepository.findAll());
    }

    public Staff create(Staff staff) {
        if (staff.getId() != null && this.staffRepository.existsById(staff.getId())) {
            throw new StaffAlreadyPresentException(staff.getId());
        }
        return staffRepository.save(staff);
    }

    public Staff update(Staff staff) {
        if (!this.staffRepository.existsById(staff.getId())) {
            throw new StaffNotFoundException(staff.getId());
        }
        return this.staffRepository.save(staff);
    }

    public void deleteById(Long staffId) {
        if (!this.staffRepository.existsById(staffId)) {
            throw new StaffNotFoundException(staffId);
        }
        this.staffRepository.deleteById(staffId);
    }


    public Enclosure assignStaffToEnclosure(Long staffId, Long enclosureId) {

        Enclosure enclosure = this.enclosureService.getById(enclosureId);
        Staff staff = this.staffRepository.findById(staffId)
                .orElseThrow(() -> new StaffNotFoundException(staffId));
        
        return null;
    }
}
