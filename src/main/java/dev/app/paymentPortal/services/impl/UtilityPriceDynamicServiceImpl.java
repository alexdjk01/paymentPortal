package dev.app.paymentPortal.services.impl;

import dev.app.paymentPortal.domain.entities.UtilityPriceDynamic;
import dev.app.paymentPortal.repositories.UtilityPriceDynamicRepository;
import dev.app.paymentPortal.services.UtilityPriceDynamicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UtilityPriceDynamicServiceImpl implements UtilityPriceDynamicService {

    private UtilityPriceDynamicRepository utilityPriceDynamicRepository;

    public UtilityPriceDynamicServiceImpl(UtilityPriceDynamicRepository utilityPriceDynamicRepository) {
        this.utilityPriceDynamicRepository = utilityPriceDynamicRepository;
    }

    @Override
    public UtilityPriceDynamic createUtility(UtilityPriceDynamic utilityPriceDynamic) {
        return utilityPriceDynamicRepository.save(utilityPriceDynamic);
    }

    @Override
    public List<UtilityPriceDynamic> findAll() {
        return StreamSupport.stream(utilityPriceDynamicRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
