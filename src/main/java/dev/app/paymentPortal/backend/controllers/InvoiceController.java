package dev.app.paymentPortal.controllers;


import dev.app.paymentPortal.domain.dto.InvoiceDto;
import dev.app.paymentPortal.domain.entities.Invoice;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InvoiceController {

    private InvoiceService invoiceService;
    private Mapper<Invoice, InvoiceDto> invoiceMapper;

    public InvoiceController(InvoiceService invoiceService, Mapper<Invoice, InvoiceDto> invoiceMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }

    @PostMapping(path = "/invoices")
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto)
    {
        Invoice invoice = invoiceMapper.mapFrom(invoiceDto);
        Invoice savedInvoice = invoiceService.createInvoice(invoice);
        return invoiceMapper.mapTo(savedInvoice);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceDto> listInvoices()
    {
        List<Invoice> invoices =  invoiceService.findAll();
        return invoices.stream()
                .map(invoiceMapper::mapTo)
                .collect(Collectors.toList());
    }


}
