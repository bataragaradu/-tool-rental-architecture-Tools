package com.rbinnovative.tools.controller;

import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.dto.ToolsDTO;
import com.rbinnovative.tools.service.ToolsProcessorImpl;
import com.rbinnovative.tools.service.ToolAvailabilityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import static com.rbinnovative.tools.utils.Constants.TOOLS_ENDPOINT;

@RestController
@RequestMapping(value = TOOLS_ENDPOINT, method = RequestMethod.GET)
public class ToolsQueryController {

    private Logger logger = LoggerFactory.getLogger(ToolsQueryController.class);

    private final ToolsProcessorImpl toolsProcessor;
    private final ToolAvailabilityService toolsAvailabilityService;

    @Autowired
    private ToolsQueryController(ToolsProcessorImpl toolsProcessor, ToolAvailabilityService toolAvailabilityService) {
        this.toolsProcessor = toolsProcessor;
        this.toolsAvailabilityService = toolAvailabilityService;
    }

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
     * Support for GET /tools/{id} endpoint by id
     *
     * @return invoice by id
     */
    @ApiOperation(value = "Query invoice by id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success query")})
    @RequestMapping(value = "/{id}", params = {"!fields"})
    public ResponseEntity<ToolsDTO> retrieveToolsById(@PathVariable Integer id) throws ToolException {
        logger.info("GET tools with id {}", id);
        ToolsDTO toolDTO = toolsProcessor.processOneQuery(id);
        logger.info("GET tool response received {}", toolDTO);
        return ResponseEntity.ok().body(toolDTO);
    }

    /**
     * Support for GET /tools/{toolId}/availability endpoint without uri params.
     *
     * @return all tools with all fields
     */
    @ApiOperation(value = "GET all tools")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The tool availability"),
            @ApiResponse(code = 400, message = " Error if missing a mandatory parameter "),
            @ApiResponse(code = 404, message = " ")})
    @RequestMapping(value = "/{toolId}/availability")
    public ResponseEntity<List<LocalDate>> retrieveToolAvailability(@PathVariable Integer toolId) throws ToolException {
        logger.info("GET tool availability");
        List<LocalDate> toolAvailability = toolsAvailabilityService.getAvailabilityForTool(toolId);

        logger.info("GET tool availability {}", toolAvailability);
        return ResponseEntity.ok().body(toolAvailability);
    }
}
