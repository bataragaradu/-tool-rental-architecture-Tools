package com.rbinnovative.tools.service;

import com.rbinnovative.tools.exception.CategoryException;
import com.rbinnovative.tools.model.dao.Category;
import com.rbinnovative.tools.model.dao.Tools;
import com.rbinnovative.tools.repository.ToolsRepository;
import org.hibernate.annotations.LazyToOneOption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToolsProcessorImplTest {

    @Mock
    private ToolsRepository toolsRepository;

    @Mock
    private CategoryProcessorImpl categoryProcessor;

    @InjectMocks
    private ToolsProcessorImpl toolsProcessor;

    @Test
    void retrieveToolsByCategory() throws CategoryException {
        when(toolsRepository.findByCategoryId(1)).thenReturn(Arrays.asList(new Tools(), new Tools()));
        assertEquals(2,toolsProcessor.retrieveToolsByCategory(1).size());
    }

    @Test
    void retrieveToolsByCategoryException() throws CategoryException {
        when(categoryProcessor.processOneQuery(1)).thenThrow(new CategoryException("category exception"));
        CategoryException thrown = assertThrows(
                CategoryException.class,
                () -> toolsProcessor.retrieveToolsByCategory(1),
                "Expected retrieveToolsByCategory() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("category exception"));
    }

    @Test
    void retrieveToolsException() throws CategoryException {
        when(toolsRepository.findByCategoryId(1)).thenReturn(null);
        assertEquals(0,toolsProcessor.retrieveToolsByCategory(1).size());
    }
}