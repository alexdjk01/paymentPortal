package dev.app.paymentPortal.services;

import dev.app.paymentPortal.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);

    List<User> findAll();

    User createUpdateUser(Long id, User user);

    boolean isExists(Long id);

    void deleteUserById(Long id);
}
