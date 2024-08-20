package dev.app.paymentPortal.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    private Long id;
    private Double waterConsumption;
    private Double gasConsumption;
    private Double energyConsumption;
    private Double waterPrice;
    private Double gasPrice;
    private Double energyPrice;
    private String billingPeriod;
    private String titleInvoice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
