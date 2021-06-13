package com.rbinnovative.tools.model;

import java.time.LocalDateTime;

public class ToolError {
    private final LocalDateTime time;
    private final String message;

    public ToolError(String message, LocalDateTime now) {
        this.message = message;
        this.time = now;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
