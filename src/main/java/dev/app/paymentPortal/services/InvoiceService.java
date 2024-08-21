package dev.app.paymentPortal.services;

import dev.app.paymentPortal.domain.entities.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    Invoice createInvoice(Invoice invoice);

    List<Invoice> findAll();
}
