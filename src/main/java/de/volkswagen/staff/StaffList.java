package de.volkswagen.staff;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StaffList {
    private List<Staff> staffs;

    public StaffList() {
        this.staffs = new ArrayList<>();
    }

    public StaffList(List<Staff> staffs) {
        this.staffs = staffs;
        if (this.staffs == null) {
            this.staffs = new ArrayList<>();
        }
    }
}
