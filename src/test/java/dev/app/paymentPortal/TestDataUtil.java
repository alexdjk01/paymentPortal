package dev.app.paymentPortal;

import dev.app.paymentPortal.domain.Invoice;
import dev.app.paymentPortal.domain.User;

public final class TestDataUtil {

    public TestDataUtil() {
    }

    public static User createUserA()
    {
        return User.builder()
                .id(1L)
                .fullName("Andreea Ionel")
                .address("Rosiori Street, Campina")
                .build();
    }

    public static User createUserB()
    {
        return User.builder()
                .id(2L)
                .fullName("Alexandru Ionel")
                .address("Naum Ramniceanu Street, Bucharest")
                .build();
    }

    public static User createUserC()
    {
        return User.builder()
                .id(3L)
                .fullName("Ioana Stoica")
                .address("Piscului Street, Bucharest")
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
}
