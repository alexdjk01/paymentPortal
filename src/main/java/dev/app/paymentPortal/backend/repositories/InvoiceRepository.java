package dev.app.paymentPortal.repositories;

import dev.app.paymentPortal.domain.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
