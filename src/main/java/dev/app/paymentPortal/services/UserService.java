package dev.app.paymentPortal.services;

import dev.app.paymentPortal.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User createUser(User user);

    List<User> findAll();

    User createUpdateUser(Long id, User user);

    boolean isExists(Long id);

    void deleteUserById(Long id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByAddress(String fullAddress);
}
