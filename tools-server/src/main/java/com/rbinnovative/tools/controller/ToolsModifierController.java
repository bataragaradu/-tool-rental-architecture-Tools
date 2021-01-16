package com.rbinnovative.tools.controller;

import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.ToolRequest;
import com.rbinnovative.tools.service.ToolsProcessorImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.rbinnovative.tools.utils.Constants.TOOLS_ENDPOINT;

@RestController
@RequestMapping(value = TOOLS_ENDPOINT)
public class ToolsModifierController {

	private final Logger logger = LoggerFactory.getLogger(ToolsModifierController.class);

	@Autowired
	private ToolsProcessorImpl toolsProcessor;

	/**
	 * Support for POST /tools endpoint
	 * @return the id of created tools
	 */
	@ApiOperation(value = "POST tools ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Save a new tool"),
			@ApiResponse(code = 400, message = " tool already exists with that key could not be found")})
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveTool(@Valid @RequestBody ToolRequest toolRequest) throws ToolException {

		logger.info("Save a new tool {}", toolRequest);
		Integer ToolId = toolsProcessor.createTool(toolRequest).getId();
		logger.info("POST successfully saved tool with id {}",ToolId);
		return ResponseEntity.ok().body(ToolId.toString());
	}

		/**
	 * Support for DELETE /tool endpoint
	 * @return the id of deleted tool
	 */
	@ApiOperation(value = "DELETE tool ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Remove a tool"),
			@ApiResponse(code = 400, message = " tool with that id could not be found")})
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteTool(@PathVariable Integer id) throws ToolException {

		logger.info("Remove a tool with id {}", id);
		toolsProcessor.removeTool(id);
		logger.info("DELETE  response sent with no body");
		return ResponseEntity.ok().body(StringUtils.EMPTY);
	}

//	/**
//	 * Support for POST /tool endpoint
//	 * @return the id of updated tool
//	 */
//	@ApiOperation(value = "PUT tool ")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Update a tool"),
//			@ApiResponse(code = 400, message = " tool with that id could not be found")})
//	@RequestMapping(value ="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> updateTool(@PathVariable Integer id, @Valid @RequestBody ToolRequest ToolRequest) throws ToolException, BillerException {
//
//		logger.info("Update a parameter settings {} with id {}", ToolRequest, id);
//		ToolsProcessor.updateParameter(id, ToolRequest);
//		logger.info("PUT response sent with no body");
//		return ResponseEntity.ok().body(StringUtils.EMPTY);
//	}
//
//	/**
//	 * Support for DELETE /tool endpoint
//	 * @return the id of deleted tool
//	 */
//	@ApiOperation(value = "DELETE tool ")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Remove a tool"),
//			@ApiResponse(code = 400, message = " tool with that id could not be found")})
//	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> deleteTool(@PathVariable Integer id) throws ToolException {
//
//		logger.info("Remove a tool with id {}", id);
//		ToolsProcessor.removeParameter(id);
//		logger.info("DELETE  response sent with no body");
//		return ResponseEntity.ok().body(StringUtils.EMPTY);
//	}
}
