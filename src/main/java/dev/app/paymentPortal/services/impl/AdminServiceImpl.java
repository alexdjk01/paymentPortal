package dev.app.paymentPortal.services.impl;

import dev.app.paymentPortal.domain.entities.Admin;
import dev.app.paymentPortal.repositories.AdminRepository;
import dev.app.paymentPortal.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
