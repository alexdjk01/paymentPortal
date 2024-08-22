package dev.app.paymentPortal.services;

import dev.app.paymentPortal.domain.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Admin createAdmin(Admin admin);

    List<Admin> findAll();
}
