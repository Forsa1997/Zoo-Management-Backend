package de.volkswagen.enclosure;


import org.jboss.jandex.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class EnclosureService {
    private EnclosureRepository enclosureRepository;

    public EnclosureService(EnclosureRepository enclosureRepository){
        this.enclosureRepository = enclosureRepository;
    }


    public Enclosure create(Enclosure enclosure) {
        return enclosureRepository.save(enclosure);
    }

    public EnclosureList getAll() {
        List<Enclosure> enclosures = this.enclosureRepository.findAll();
        if (enclosures.isEmpty()) {
            throw new EmptyEnclosureListException();
        }
        return new EnclosureList(enclosures);
    }

    public Enclosure getById(Long enclosureId) {
        Enclosure enclosure = enclosureRepository.getById(enclosureId);
        if (enclosure == null) {
            throw new EnclosureNotFoundException();
        }
        return enclosure;
    }
}
