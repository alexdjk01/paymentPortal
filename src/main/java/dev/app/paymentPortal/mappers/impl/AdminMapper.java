package dev.app.paymentPortal.mappers.impl;

import dev.app.paymentPortal.domain.dto.AdminDto;
import dev.app.paymentPortal.domain.entities.Admin;
import dev.app.paymentPortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper implements Mapper<Admin, AdminDto> {

    private ModelMapper modelMapper;

    public AdminMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AdminDto mapTo(Admin admin) {
        return modelMapper.map(admin,AdminDto.class);
    }

    @Override
    public Admin mapFrom(AdminDto adminDto) {
        return modelMapper.map(adminDto, Admin.class);
    }
}
