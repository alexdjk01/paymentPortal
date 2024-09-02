package dev.app.paymentPortal.controllers;


import dev.app.paymentPortal.domain.dto.InvoiceDto;
import dev.app.paymentPortal.domain.dto.UserDto;
import dev.app.paymentPortal.domain.entities.Invoice;
import dev.app.paymentPortal.mappers.Mapper;
import dev.app.paymentPortal.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
public class InvoiceController {

    private InvoiceService invoiceService;
    private Mapper<Invoice, InvoiceDto> invoiceMapper;

    public InvoiceController(InvoiceService invoiceService, Mapper<Invoice, InvoiceDto> invoiceMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }

    @PostMapping(path = "/invoices")
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto) throws Exception {
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

    @GetMapping(path = "/invoices/user/{id}")
    public List<InvoiceDto> getInvoicesCorrespondingToOneUser(@PathVariable Long id)
    {
        List<Invoice> invoices = invoiceService.findInvoicesOfUserWithId(id);
        return invoices.stream()
                .map(invoiceMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/invoices/{id}")
    public ResponseEntity<InvoiceDto> createUpdateInvoice(@PathVariable Long id, @RequestBody InvoiceDto invoiceDto)
    {
        Invoice invoice = invoiceMapper.mapFrom(invoiceDto);
        boolean invoiceExists = invoiceService.isExists(id);
        Invoice updatedInvoice = invoiceService.createUpdateInvoice(id,invoice);
        InvoiceDto updatedInvoiceDto = invoiceMapper.mapTo(updatedInvoice);
        if(invoiceExists)
        {
            return new ResponseEntity<>(updatedInvoiceDto, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(updatedInvoiceDto, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(path = "/invoices/{id}")
    public ResponseEntity<String> deleteInvoiceById(@PathVariable Long id)
    {
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity<>("Invoice successfully DELETED", HttpStatus.OK);
    }


}
