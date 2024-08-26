package dev.app.paymentPortal.controllers;

import dev.app.paymentPortal.domain.dto.AdminDto;
import dev.app.paymentPortal.domain.entities.Admin;
import dev.app.paymentPortal.domain.entities.User;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping(path = "/admins/{email}")
    public ResponseEntity<AdminDto> getAdminByEmail(@PathVariable String email)
    {
        Optional<Admin> adminFound = adminService.findAdminByEmail(email);
        if(adminFound.isPresent())
        {
            AdminDto adminDto = adminMapper.mapTo(adminFound.get());
            return new ResponseEntity<>(adminDto,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/admins/{id}")
    public ResponseEntity<AdminDto> createUpdateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto)
    {
        Admin admin = adminMapper.mapFrom(adminDto);
        boolean adminExists = adminService.isExists(id);
        Admin updatedAdmin = adminService.createUpdateAdmin(id,admin);
        AdminDto adminDtoUpdated = adminMapper.mapTo(updatedAdmin);
        if(adminExists)
        {
            return new ResponseEntity<>(adminDtoUpdated, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(adminDtoUpdated, HttpStatus.CREATED);
        }
    }

    @DeleteMapping (path = "/admins/{id}")
    public ResponseEntity<String> deleteAdminById(@PathVariable Long id)
    {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>("Admin successfully DELETED", HttpStatus.OK);

    }

}
