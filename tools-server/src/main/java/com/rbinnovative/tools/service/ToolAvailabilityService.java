package com.rbinnovative.tools.service;

import com.rb.innovative.client.controller.DefaultApi;
import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.dao.Tools;
import com.rbinnovative.tools.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ToolAvailabilityService {

    private final ToolsRepository toolRepository;

    //TODO: add Orders client

    @Autowired
    public ToolAvailabilityService(ToolsRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public List<LocalDate> getAvailabilityForTool(Integer toolId) throws ToolException {
        Optional<Tools> toolRetrieved = toolRepository.findById(toolId);
        if (toolRetrieved.isPresent() && toolRetrieved.get().isAvailable()) {
            return extractAvailableDate();
        } else {
            throw new ToolException("The id doesn't exist, needs to be created " + toolId);
        }
    }

    private List<LocalDate> extractAvailableDate() {
        LocalDate localDateNextMonth = LocalDate.now().plusMonths(1);
        LocalDate localDateEndOfNextMonth= localDateNextMonth.withDayOfMonth(localDateNextMonth.lengthOfMonth());
        int numberOfDaysBetween = localDateEndOfNextMonth.getDayOfYear() + 1 - LocalDate.now().getDayOfYear() ;
        return Stream.iterate(LocalDate.now(), d -> d.plusDays(1))
                .limit(numberOfDaysBetween)
                .collect(Collectors.toList());
    }
}
