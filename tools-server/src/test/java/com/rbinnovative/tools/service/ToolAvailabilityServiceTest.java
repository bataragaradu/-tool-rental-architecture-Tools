package com.rbinnovative.tools.service;

import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.dao.Tools;
import com.rbinnovative.tools.repository.ToolsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToolAvailabilityServiceTest {

    @InjectMocks
    private ToolAvailabilityService toolAvailabilityService;

    @Mock
    private ToolsRepository toolsRepository;

    @Test
    void getAvailabilityForTool() throws Exception {
        Tools tool = new Tools();
        tool.setAvailable(true);
        when(toolsRepository.findById(1)).thenReturn(Optional.of(tool));
        toolAvailabilityService.getAvailabilityForTool(1);
    }

    @Test()
    void getAvailabilityForToolException()  {
        Tools tool = new Tools();
        when(toolsRepository.findById(1)).thenReturn(Optional.of(tool));
        assertThrows(ToolException.class, () -> toolAvailabilityService.getAvailabilityForTool(1));

    }
}