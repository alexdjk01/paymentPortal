package dev.app.paymentPortal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilityPriceDynamicDto {

    private Long id;
    private String utilityType;
    private double pricePerUnit;

}
