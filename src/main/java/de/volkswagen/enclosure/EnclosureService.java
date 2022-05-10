package de.volkswagen.enclosure;


import org.jboss.jandex.ClassInfo;
import org.springframework.stereotype.Service;

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
}
