package de.volkswagen.enclosure;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnclosureList {
    private List<Enclosure> enclosures;

    public EnclosureList() {
        this.enclosures = new ArrayList<>();
    }

    public EnclosureList(List<Enclosure> enclosures) {
        this.enclosures = enclosures;
        if (this.enclosures == null) {
            this.enclosures = new ArrayList<>();
        }
    }
}
