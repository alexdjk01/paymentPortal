package dev.app.paymentPortal.services.impl;

import dev.app.paymentPortal.domain.entities.Invoice;
import dev.app.paymentPortal.repositories.InvoiceRepository;
import dev.app.paymentPortal.services.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return StreamSupport.stream(invoiceRepository.findAll().spliterator(), false).collect(Collectors.toList()) ;
    }
}
