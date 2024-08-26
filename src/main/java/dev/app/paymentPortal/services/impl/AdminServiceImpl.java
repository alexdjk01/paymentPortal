package dev.app.paymentPortal.services.impl;

import dev.app.paymentPortal.domain.entities.Admin;
import dev.app.paymentPortal.repositories.AdminRepository;
import dev.app.paymentPortal.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return StreamSupport.stream(adminRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public boolean isExists(Long id) {
        return adminRepository.existsById(id);
    }

    @Override
    public Admin createUpdateAdmin(Long id, Admin admin) {
       admin.setId(id);
       return adminRepository.save(admin);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> findAdminByEmail(String email) {
        Optional<Admin> admin = StreamSupport.stream(adminRepository.findAll().spliterator(), false).filter(e -> e.getEmail().equals(email)).findFirst();
        return admin;
    }
}
