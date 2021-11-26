package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;

import java.util.List;
import java.util.Optional;

@Service
public interface InstitutionService {

    List<Institution> getInstitutions ();
    Optional<Institution> findById (Long id);
    void save(Institution institution);
    void update(Institution institution);
    void remove(Institution institution);

}
