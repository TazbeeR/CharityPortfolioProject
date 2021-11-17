package pl.coderslab.charity.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;
@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public List<Institution> getInstitutions () {
        return institutionRepository.findAll();
    }

}
