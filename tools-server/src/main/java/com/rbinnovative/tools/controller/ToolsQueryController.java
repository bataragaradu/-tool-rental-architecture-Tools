package com.rbinnovative.tools.controller;

import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.dto.ToolsDTO;
import com.rbinnovative.tools.service.ToolsProcessorImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.rbinnovative.tools.utils.Constants.TOOLS_ENDPOINT;

@RestController
@RequestMapping(value = TOOLS_ENDPOINT, method = RequestMethod.GET)
public class ToolsQueryController {


    private Logger logger = LoggerFactory.getLogger(ToolsQueryController.class);

    @Autowired
    private ToolsProcessorImpl toolsProcessor;

    /**
     * Support for GET /tools endpoint without uri params.
     *
     * @return all tools with all fields
     */
    @ApiOperation(value = "GET all tools")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The tools"),
            @ApiResponse(code = 400, message = " Error if missing a mandatory parameter "),
            @ApiResponse(code = 404, message = " ")})
    @RequestMapping
    public ResponseEntity<List<ToolsDTO>> retrieveAllTools() {
        logger.info("GET all tools");
        List<ToolsDTO> toolsDTOs = toolsProcessor.processAllQuery();

        logger.info("GET all tools response {}", toolsDTOs);
        return ResponseEntity.ok().body(toolsDTOs);
    }

    /**
     * Support for GET /tools endpoint by id
     *
     * @return invoice by id
     */
    @ApiOperation(value = "Query invoice by id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success query")})
    @RequestMapping(value = "/{id}", params = {"!fields"})
    public ResponseEntity<ToolsDTO> retrieveInvoiceById(@PathVariable Integer id) throws ToolException {
        logger.info("GET invoice with id {}", id);
        ToolsDTO invoiceDTO = toolsProcessor.processOneQuery(id);
        logger.info("GET invoice response received {}", invoiceDTO);
        return ResponseEntity.ok().body(invoiceDTO);
    }
}
