package dev.app.paymentPortal.services;

import dev.app.paymentPortal.domain.entities.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    Invoice createInvoice(Invoice invoice) throws Exception;

    List<Invoice> findAll();

    boolean isExists(Long id);

    Invoice createUpdateInvoice(Long id, Invoice invoice);

    void deleteInvoiceById(Long id);

    List<Invoice> findInvoicesOfUserWithId(Long id);
}
