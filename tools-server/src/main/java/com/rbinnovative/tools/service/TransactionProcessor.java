package com.rbinnovative.tools.service;

import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.ToolRequest;
import com.rbinnovative.tools.model.ToolsDTO;

public interface TransactionProcessor {
    ToolsDTO createTool(ToolRequest toolRequest);

    //    @Override
    //    public InvoiceDTO updateParameter(Integer id, InvoiceRequest invoiceRequest) throws InvoiceException, BillerException {
    //        Optional<Invoice> requestUpdateId = Optional.empty();
    //        if (id != null) {
    //            requestUpdateId = invoiceRepository.findById(id);
    //        }
    //        if (requestUpdateId.isPresent()) {
    //            Invoice updateInvoice = requestUpdateId.get();
    //            Utils.copyProperties(invoiceRequest, updateInvoice, invoiceRequestFields);
    //            updateInvoice.setUpdatedAt(LocalDateTime.now());
    //            updateInvoice.setBillerId(extractBillerId(invoiceRequest.getBillerId()));
    //            updateInvoice = invoiceRepository.save(updateInvoice);
    //            return mapToInvoiceDTOHandler(updateInvoice, null);
    //        } else {
    //            throw new InvoiceException("The id " + id + " doesn't exist, needs to be created ");
    //        }
    //    }
    //
    void removeTool(Integer id) throws ToolException;
}
