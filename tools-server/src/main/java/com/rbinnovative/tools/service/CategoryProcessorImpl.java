package com.rbinnovative.tools.service;

import com.rbinnovative.tools.exception.CategoryException;
import com.rbinnovative.tools.model.dto.CategoryDTO;
import com.rbinnovative.tools.model.dao.Category;
import com.rbinnovative.tools.repository.CategoryRepository;
import com.rbinnovative.tools.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryProcessorImpl implements QueryProcessor<CategoryDTO>{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryProcessorImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO processOneQuery(Integer id) throws CategoryException {
        Optional<Category> toolOptional = categoryRepository.findById(id);
        Optional<CategoryDTO> toolsDTO = toolOptional.map((toolsElem) -> mapToCategoryDTOHandler(toolsElem, null));
        if (toolsDTO.isPresent()) {
            return toolsDTO.get();
        } else {
            throw new CategoryException("The id doesn't exist, needs to be created " + id);
        }
    }

    @Override
    public List<CategoryDTO> processAllQuery() {
        List<Category> categories = Optional.ofNullable(categoryRepository.findAll()).orElseGet(ArrayList::new);
        return categories.stream().map((toolsElem) -> mapToCategoryDTOHandler(toolsElem, null)).collect(Collectors.toList());
    }

    private CategoryDTO mapToCategoryDTOHandler(Category tools, List<String> fields) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (fields != null) {
            Utils.copyProperties(tools, categoryDTO, fields);
        } else {
            BeanUtils.copyProperties(tools, categoryDTO);
        }
        return categoryDTO;
    }
}
