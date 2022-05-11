package de.volkswagen.enclosure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnclosureList {
    List<Enclosure> enclosures;

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
