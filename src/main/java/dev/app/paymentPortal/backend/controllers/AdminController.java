package dev.app.paymentPortal.controllers;

import dev.app.paymentPortal.domain.dto.AdminDto;
import dev.app.paymentPortal.domain.entities.Admin;
import dev.app.paymentPortal.domain.entities.User;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdminController {

    private AdminService adminService;
    private Mapper<Admin, AdminDto> adminMapper;

    public AdminController(AdminService adminService, Mapper<Admin, AdminDto> adminMapper) {
        this.adminService = adminService;
        this.adminMapper = adminMapper;
    }

    @PostMapping(path = "/admins")
    public AdminDto createAdmin(@RequestBody AdminDto adminDto) {

        Admin admin = adminMapper.mapFrom(adminDto);
        Admin savedAdmin = adminService.createAdmin(admin);
        return adminMapper.mapTo(savedAdmin);
    }

    @GetMapping(path = "/admins")
    public List<AdminDto> listUsers()
    {
        List<Admin> admins = adminService.findAll();
        return admins.stream()
                .map(adminMapper::mapTo)
                .collect(Collectors.toList());
    }

}
