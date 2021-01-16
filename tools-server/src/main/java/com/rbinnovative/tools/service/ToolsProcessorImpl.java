package com.rbinnovative.tools.service;

import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.ToolRequest;
import com.rbinnovative.tools.model.Tools;
import com.rbinnovative.tools.model.ToolsDTO;
import com.rbinnovative.tools.repository.ToolsRepository;
import com.rbinnovative.tools.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolsProcessorImpl implements TransactionProcessor {

    @Autowired
    private ToolsRepository toolsRepository;

    @Override
    public ToolsDTO createTool(ToolRequest toolRequest) {
        Tools createTools = processToolCreation(toolRequest);
        createTools = toolsRepository.save(createTools);
        return mapToToolsDTOHandler(createTools, null);
    }

    @Override
    public void removeTool(Integer id) throws ToolException {
        Optional<Tools> toolsOptional = toolsRepository.findById(id);

        if (toolsOptional.isPresent()) {
            toolsRepository.delete(toolsOptional.get());
        } else {
            throw new ToolException("Invoice with requested id doesn't exist");
        }
    }


    private ToolsDTO mapToToolsDTOHandler(Tools tools, List<String> fields) {
        ToolsDTO toolDTO = new ToolsDTO();
        if (fields != null) {
            Utils.copyProperties(tools, toolDTO, fields);
        } else {
            BeanUtils.copyProperties(tools, toolDTO);
        }
        return toolDTO;
    }

    private Tools processToolCreation(ToolRequest toolRequest) {
        Tools createTool = new Tools();
        BeanUtils.copyProperties(toolRequest, createTool);
        //Particular request entities
        return createTool;
    }
}
//    public List<ToolsDTO> processAllQuery(QueryRequest queryRequest) {
//        List<Tools> tools = Optional.ofNullable(toolsRepository.findAll()).orElseGet(ArrayList::new);
//        return tools.stream().map((tools) -> mapToToolsDTOHandler(tools, queryRequest.getFields())).collect(Collectors.toList());
//    }
//
//    @Override
//    public InvoiceDTO processOneQuery(Integer id, QueryRequest queryRequest) throws BillerException {
//        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
//        Optional<InvoiceDTO> billingResponse = invoiceOptional.map((invoice) -> mapToInvoiceDTOHandler(invoice, queryRequest.getFields()));
//        if (billingResponse.isPresent()) {
//            return billingResponse.get();
//        } else {
//            throw new BillerException("The id doesn't exist, needs to be created " + id);
//        }
//    }


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

