package dev.app.paymentPortal.repositories;

import dev.app.paymentPortal.TestDataUtil;
import dev.app.paymentPortal.domain.Invoice;
import dev.app.paymentPortal.domain.User;
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
public class InvoiceRepositoryIntegrationTest {

    private InvoiceRepository underTest;

    @Autowired
    public InvoiceRepositoryIntegrationTest(InvoiceRepository underTest) {
        this.underTest = underTest;
    }


    @Test
    public void testThatInvoiceCanBeCreatedAndRecalled()
    {
        User user = TestDataUtil.createUserA();
        Invoice invoice = TestDataUtil.createInvoiceA(user);
        underTest.save(invoice);
        Optional<Invoice> result = underTest.findById(invoice.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(invoice);
    }

    @Test
    public void testThatMultipleInvoicesCanBeCreatedAndRecalled()
    {
        User userA = TestDataUtil.createUserA();
        Invoice invoiceA =TestDataUtil.createInvoiceA(userA);
        underTest.save(invoiceA);
        Invoice invoiceB =TestDataUtil.createInvoiceB(userA);
        underTest.save(invoiceB);
        Invoice invoiceC =TestDataUtil.createInvoiceC(userA);
        underTest.save(invoiceC);

        Iterable<Invoice> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(invoiceA, invoiceB, invoiceC);

    }

    @Test
    public void testThatInvoiceCanBeUpdated()
    {
        User userA = TestDataUtil.createUserA();
        Invoice invoiceA =TestDataUtil.createInvoiceA(userA);
        underTest.save(invoiceA);

        invoiceA.setBillingPeriod("UPDATED PERIOD");
        underTest.save(invoiceA);

        Optional<Invoice> result=  underTest.findById(invoiceA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(invoiceA);
    }

    @Test
    public void testThatInvoiceCanBeDeleted()
    {
        User userA = TestDataUtil.createUserA();

        Invoice invoiceA =TestDataUtil.createInvoiceA(userA);
        underTest.save(invoiceA);

        underTest.delete(invoiceA);  ///    underTest.deleteById(invoiceA.getId());
        Optional<Invoice> result = underTest.findById(invoiceA.getId());
        assertThat(result).isEmpty();
    }


}
