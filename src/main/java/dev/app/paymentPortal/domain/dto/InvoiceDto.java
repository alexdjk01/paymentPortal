package dev.app.paymentPortal.domain.dto;

import dev.app.paymentPortal.domain.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InvoiceDto {

    private Long id;
    private Double waterConsumption;
    private Double gasConsumption;
    private Double energyConsumption;
    private Double waterPrice;
    private Double gasPrice;
    private Double energyPrice;
    private String billingPeriod;
    private String titleInvoice;
    private User user;

}
