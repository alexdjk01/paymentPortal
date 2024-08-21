package dev.app.paymentPortal;

import dev.app.paymentPortal.domain.entities.Invoice;
import dev.app.paymentPortal.domain.entities.User;
import dev.app.paymentPortal.domain.entities.UtilityPriceDynamic;

public final class TestDataUtil {

    public TestDataUtil() {
    }

    public static User createUserA()
    {
        return User.builder()
                .id(1L)
                .fullName("Andreea Ionel")
                .address("Rosiori Street, Campina")
                .email("andreeaionel@gmail.com")
                .password("andreea1234")
                .build();
    }

    public static User createUserB()
    {
        return User.builder()
                .id(2L)
                .fullName("Alexandru Ionel")
                .address("Naum Ramniceanu Street, Bucharest")
                .email("alexionel@gmail.com")
                .password("alex1234")
                .build();
    }

    public static User createUserC()
    {
        return User.builder()
                .id(3L)
                .fullName("Ioana Stoica")
                .address("Piscului Street, Bucharest")
                .email("ionaastoica@gmail.com")
                .password("ioana1234")
                .build();
    }

    public static Invoice createInvoiceA(final User user)
    {
        return Invoice.builder()
                .id(1L)
                .waterConsumption(10.0)
                .waterPrice(1.0)
                .energyConsumption(10.0)
                .energyPrice(2.0)
                .gasConsumption(10.0)
                .gasPrice(2.0)
                .billingPeriod("MARCH")
                .user(user)
                .titleInvoice("")
                .build();
    }

    public static Invoice createInvoiceB(final User user)
    {
        return Invoice.builder()
                .id(2L)
                .waterConsumption(10.0)
                .waterPrice(1.0)
                .energyConsumption(10.0)
                .energyPrice(2.0)
                .gasConsumption(10.0)
                .gasPrice(2.0)
                .billingPeriod("JULY")
                .user(user)
                .build();
    }

    public static Invoice createInvoiceC(final User user)
    {
        return Invoice.builder()
                .id(3L)
                .waterConsumption(10.0)
                .waterPrice(1.0)
                .energyConsumption(10.0)
                .energyPrice(2.0)
                .gasConsumption(10.0)
                .gasPrice(2.0)
                .billingPeriod("APRIL")
                .user(user)
                .build();
    }

    public static UtilityPriceDynamic createUtilityPrice() {
        return UtilityPriceDynamic.builder()
                .id(1L)
                .utilityType("Water Bill")
                .pricePerUnit(2.0)
                .build();
    }
}
