package dev.app.paymentPortal.controllers;

import dev.app.paymentPortal.domain.dto.UtilityPriceDynamicDto;
import dev.app.paymentPortal.domain.entities.UtilityPriceDynamic;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.UtilityPriceDynamicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UtilityPriceDynamicController {

    private UtilityPriceDynamicService utilityPriceDynamicService;
    private Mapper<UtilityPriceDynamic, UtilityPriceDynamicDto> utilityMapper;

    public UtilityPriceDynamicController(UtilityPriceDynamicService utilityPriceDynamicService, Mapper<UtilityPriceDynamic, UtilityPriceDynamicDto> utilityMapper) {
        this.utilityPriceDynamicService = utilityPriceDynamicService;
        this.utilityMapper = utilityMapper;
    }

    @PostMapping(path = "/utilityPrice")
    public UtilityPriceDynamicDto createUtilityPriceDtop(@RequestBody UtilityPriceDynamicDto utilityPriceDynamicDto)
    {
        UtilityPriceDynamic utilityPriceDynamic = utilityMapper.mapFrom(utilityPriceDynamicDto);
        UtilityPriceDynamic savedUtilityPriceDynamic = utilityPriceDynamicService.createUtility(utilityPriceDynamic);
        return utilityMapper.mapTo(savedUtilityPriceDynamic);
    }

    @GetMapping(path = "/utilityPrice")
    public List<UtilityPriceDynamicDto> listUtilities()
    {
        List<UtilityPriceDynamic> utilities = utilityPriceDynamicService.findAll();
        return utilities.stream()
                .map(utilityMapper::mapTo)
                .collect(Collectors.toList());
    }
}
