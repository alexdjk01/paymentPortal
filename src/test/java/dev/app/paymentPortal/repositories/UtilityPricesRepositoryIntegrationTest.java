package dev.app.paymentPortal.repositories;


import dev.app.paymentPortal.TestDataUtil;
import dev.app.paymentPortal.domain.entities.UtilityPriceDynamic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UtilityPricesRepositoryIntegrationTest {

    private UtilityPriceDynamicRepository underTest;

    @Autowired
    public UtilityPricesRepositoryIntegrationTest(UtilityPriceDynamicRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatUtilityPriceCanBeCreatedAndRecalled()
    {
        UtilityPriceDynamic utilityPriceDynamic = TestDataUtil.createUtilityPrice();
        underTest.save(utilityPriceDynamic);
        Optional<UtilityPriceDynamic> result = underTest.findById(utilityPriceDynamic.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(utilityPriceDynamic);

    }
}
