package dev.app.paymentPortal.services;

import dev.app.paymentPortal.domain.entities.UtilityPriceDynamic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilityPriceDynamicService {

    UtilityPriceDynamic createUtility(String utility, UtilityPriceDynamic utilityPriceDynamic);

    List<UtilityPriceDynamic> findAll();
}
