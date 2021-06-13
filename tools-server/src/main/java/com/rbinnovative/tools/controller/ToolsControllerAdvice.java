package com.rbinnovative.tools.controller;

import com.rbinnovative.tools.exception.CategoryException;
import com.rbinnovative.tools.exception.ToolException;
import com.rbinnovative.tools.model.ToolError;
import com.rbinnovative.tools.model.dao.Category;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ToolsControllerAdvice {

    @ExceptionHandler(value
            = { ToolException.class, CategoryException.class })
    public ResponseEntity<ToolError> handleConflict(
            Exception ex, WebRequest request) {
        ToolError toolError = new ToolError(ex.getMessage() , LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(toolError);
    }
}
