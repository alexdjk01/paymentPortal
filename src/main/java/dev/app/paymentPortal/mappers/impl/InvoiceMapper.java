package dev.app.paymentPortal.mappers.impl;


import dev.app.paymentPortal.domain.dto.InvoiceDto;
import dev.app.paymentPortal.domain.entities.Invoice;
import dev.app.paymentPortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper implements Mapper<Invoice, InvoiceDto> {

    private ModelMapper modelMapper;

    public InvoiceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public InvoiceDto mapTo(Invoice invoice) {
        return modelMapper.map(invoice,InvoiceDto.class);
    }

    @Override
    public Invoice mapFrom(InvoiceDto invoiceDto) {
        return modelMapper.map(invoiceDto,Invoice.class);
    }
}
