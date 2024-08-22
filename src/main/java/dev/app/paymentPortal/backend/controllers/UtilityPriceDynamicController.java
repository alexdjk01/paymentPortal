package dev.app.paymentPortal.controllers;

import dev.app.paymentPortal.domain.dto.UtilityPriceDynamicDto;
import dev.app.paymentPortal.domain.entities.UtilityPriceDynamic;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.UtilityPriceDynamicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/utilityPrices")
    public List<UtilityPriceDynamicDto> listUtilities()
    {
        List<UtilityPriceDynamic> utilities = utilityPriceDynamicService.findAll();
        return utilities.stream()
                .map(utilityMapper::mapTo)
                .collect(Collectors.toList());
    }


    @PutMapping(path = "/utilityPrices/{utility}")
    public ResponseEntity<UtilityPriceDynamicDto> createUtilityPrice(@PathVariable String utility, @RequestBody UtilityPriceDynamicDto utilityPriceDynamicDto)
    {
        UtilityPriceDynamic utilityPriceDynamic = utilityMapper.mapFrom(utilityPriceDynamicDto);
        UtilityPriceDynamic savedUtilityPriceDynamic = utilityPriceDynamicService.createUtility(utility, utilityPriceDynamic);
        UtilityPriceDynamicDto savedUtilityPriceDto  = utilityMapper.mapTo(savedUtilityPriceDynamic);
        return new ResponseEntity<>(savedUtilityPriceDto, HttpStatus.CREATED);


    }

}
