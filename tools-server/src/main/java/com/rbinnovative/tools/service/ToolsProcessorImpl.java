package com.rbinnovative.tools.service;

import com.rbinnovative.tools.exception.CategoryException;
import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.request.ToolRequest;
import com.rbinnovative.tools.model.dao.Tools;
import com.rbinnovative.tools.model.dto.ToolsDTO;
import com.rbinnovative.tools.repository.ToolsRepository;
import com.rbinnovative.tools.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToolsProcessorImpl implements TransactionProcessor {

    @Autowired
    private ToolsRepository toolsRepository;

    @Autowired
    private CategoryProcessorImpl categoryProcessor;

    @Override
    public ToolsDTO processOneQuery(Integer id) throws ToolException {
        Optional<Tools> toolOptional = toolsRepository.findById(id);
        Optional<ToolsDTO> toolsDTO = toolOptional.map((toolsElem) -> mapToToolsDTOHandler(toolsElem, null));
        if (toolsDTO.isPresent()) {
            return toolsDTO.get();
        } else {
            throw new ToolException("The id doesn't exist, needs to be created " + id);
        }
    }

    public List<ToolsDTO> retrieveToolsByCategory(Integer categoryId) throws CategoryException {
        categoryProcessor.processOneQuery(categoryId);
        List<Tools> toolsForQueriedCategoryId = toolsRepository.findByCategoryId(categoryId);
        List<ToolsDTO> queriedToolsDtos = new ArrayList<>();
        if(toolsForQueriedCategoryId !=null){
            queriedToolsDtos = toolsForQueriedCategoryId.stream().map(tool -> mapToToolsDTOHandler(tool, null)).collect(Collectors.toList());
        }
        return queriedToolsDtos;
    }

    @Override
    public List<ToolsDTO> processAllQuery() {
        List<Tools> tools = Optional.ofNullable(toolsRepository.findAll()).orElseGet(ArrayList::new);
        return tools.stream().map((toolsElem) -> mapToToolsDTOHandler(toolsElem, null)).collect(Collectors.toList());
    }

    @Override
    public ToolsDTO createTool(ToolRequest toolRequest) {
        Tools createdTool = processToolCreation(toolRequest);
        createdTool = toolsRepository.save(createdTool);
        return mapToToolsDTOHandler(createdTool, null);
    }

    @Override
    public void removeTool(Integer id) throws ToolException {
        Optional<Tools> toolsOptional = toolsRepository.findById(id);

        if (toolsOptional.isPresent()) {
            toolsRepository.delete(toolsOptional.get());
        } else {
            throw new ToolException("Tools with requested id doesn't exist");
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

