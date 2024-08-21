package dev.app.paymentPortal.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "utility_prices")
//class used for changing the prices of the utilities dynamically
public class UtilityPriceDynamic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utility_prices_seq")
    private Long id;
    private String utilityType;
    private double pricePerUnit;
}
