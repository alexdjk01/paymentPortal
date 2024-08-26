package dev.app.paymentPortal.services;

import dev.app.paymentPortal.domain.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {

    Admin createAdmin(Admin admin);

    List<Admin> findAll();

    boolean isExists(Long id);

    Admin createUpdateAdmin(Long id, Admin admin);

    void deleteAdminById(Long id);

    Optional<Admin> findAdminByEmail(String email);
}
