package com.rbinnovative.tools.controller;

import com.rbinnovative.tools.exception.CategoryException;
import com.rbinnovative.tools.model.dto.CategoryDTO;
import com.rbinnovative.tools.service.CategoryProcessorImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rbinnovative.tools.utils.Constants.CATEGORY_ENDPOINT;


@RestController
@RequestMapping(value = CATEGORY_ENDPOINT, method = RequestMethod.GET)
public class CategoryController {

    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private CategoryProcessorImpl categoryProcessor;

    public CategoryController(CategoryProcessorImpl categoryProcessor){
        this.categoryProcessor = categoryProcessor;
    }


    /**
     * Support for GET /category endpoint without uri params.
     *
     * @return all category with all fields
     */
    @ApiOperation(value = "GET all category")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The category"),
            @ApiResponse(code = 400, message = " Error if missing a mandatory parameter "),
            @ApiResponse(code = 404, message = " ")})
    @RequestMapping
    public ResponseEntity<List<CategoryDTO>> retrieveAllCategory() {
        logger.info("GET all category");
        List<CategoryDTO> categoryDTOS = categoryProcessor.processAllQuery();

        logger.info("GET all category response {}", categoryDTOS);
        return ResponseEntity.ok().body(categoryDTOS);
    }

    /**
     * Support for GET /category endpoint by id
     *
     * @return category by id
     */
    @ApiOperation(value = "Category by id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success query")})
    @RequestMapping(value = "/{id}", params = {"!fields"})
    public ResponseEntity<CategoryDTO> retrieveCategoryById(@PathVariable Integer id) throws CategoryException {
        logger.info("GET category with id {}", id);
        CategoryDTO categoryDTO = categoryProcessor.processOneQuery(id);
        logger.info("GET category response received {}", categoryDTO);
        return ResponseEntity.ok().body(categoryDTO);
    }
}
