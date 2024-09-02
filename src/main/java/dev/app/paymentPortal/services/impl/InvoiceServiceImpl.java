package dev.app.paymentPortal.services.impl;

import dev.app.paymentPortal.domain.entities.Invoice;
import dev.app.paymentPortal.domain.entities.User;
import dev.app.paymentPortal.repositories.InvoiceRepository;
import dev.app.paymentPortal.repositories.UserRepository;
import dev.app.paymentPortal.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    @Autowired
    private UserRepository userRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) throws Exception {
        if(invoice.getUser() != null && invoice.getUser().getId() != null)
        {
            User user  = userRepository.findById(invoice.getUser().getId()).orElseThrow( () -> new Exception("User not found!"));
            invoice.setUser(user);
        }
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return StreamSupport.stream(invoiceRepository.findAll().spliterator(), false).collect(Collectors.toList()) ;
    }

    @Override
    public boolean isExists(Long id) {
        return invoiceRepository.existsById(id);
    }

    @Override
    public Invoice createUpdateInvoice(Long id, Invoice invoice) {

        invoice.setId(id);
        return invoiceRepository.save(invoice);

    }

    @Override
    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoice> findInvoicesOfUserWithId(Long id) {
        return StreamSupport.stream(invoiceRepository.findAll().spliterator(),false)
                .filter(e -> e.getUser().getId().equals(id))
                .collect(Collectors.toList());
    }
}
