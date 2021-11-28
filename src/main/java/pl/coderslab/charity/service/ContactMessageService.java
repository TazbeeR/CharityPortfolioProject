package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.ContactMessage;

import java.util.List;
import java.util.Optional;

@Service
public interface ContactMessageService {

    void save(ContactMessage contactMessage);
    Optional<ContactMessage> findById(Long id);
    void remove(ContactMessage contactMessage);
    List<ContactMessage>findAll();

}
