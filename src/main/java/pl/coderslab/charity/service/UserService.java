package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByUserName(String email);
    void save(User user);

}
