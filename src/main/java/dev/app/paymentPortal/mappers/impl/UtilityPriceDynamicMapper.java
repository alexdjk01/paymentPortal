package dev.app.paymentPortal.mappers.impl;

import dev.app.paymentPortal.domain.dto.UtilityPriceDynamicDto;
import dev.app.paymentPortal.domain.entities.UtilityPriceDynamic;
import dev.app.paymentPortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UtilityPriceDynamicMapper implements Mapper<UtilityPriceDynamic, UtilityPriceDynamicDto> {

    private ModelMapper modelMapper;

    public UtilityPriceDynamicMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UtilityPriceDynamicDto mapTo(UtilityPriceDynamic utilityPriceDynamic) {
        return modelMapper.map(utilityPriceDynamic, UtilityPriceDynamicDto.class);
    }

    @Override
    public UtilityPriceDynamic mapFrom(UtilityPriceDynamicDto utilityPriceDynamicDto) {
        return modelMapper.map(utilityPriceDynamicDto, UtilityPriceDynamic.class);
    }
}
