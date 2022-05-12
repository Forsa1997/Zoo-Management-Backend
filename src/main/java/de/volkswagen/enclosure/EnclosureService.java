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
        if (enclosure.getId() != null && this.enclosureRepository.existsById(enclosure.getId())) {
            throw new EnclosureAlreadyPresentException();
        }
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
        return enclosureRepository.findById(enclosureId)
                .orElseThrow(EnclosureNotFoundException::new);
    }

    public Enclosure update(Enclosure enclosure) {
            if (!this.enclosureRepository.existsById(enclosure.getId())) {
                throw new EnclosureNotFoundException();
            }
            return this.enclosureRepository.save(enclosure);
    }

    public void deleteById(Long enclosureId) {
        if(!this.enclosureRepository.existsById(enclosureId)) {
            throw new EnclosureNotFoundException();
        }
        this.enclosureRepository.deleteById(enclosureId);
    }
}
