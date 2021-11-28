package pl.coderslab.charity.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.ContactMessage;
import pl.coderslab.charity.repository.ContactMessageRepository;
import pl.coderslab.charity.service.ContactMessageService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {
    private final ContactMessageRepository contactMessageRepository;

    @Override
    public void save(ContactMessage contactMessage) {
        contactMessageRepository.save(contactMessage);
    }

    @Override
    public Optional<ContactMessage> findById(Long id) {
        return contactMessageRepository.findById(id);
    }

    @Override
    public void remove(ContactMessage contactMessage) {
        contactMessageRepository.delete(contactMessage);
    }

    @Override
    public List<ContactMessage> findAll() {
        return contactMessageRepository.findAll();
    }
}
