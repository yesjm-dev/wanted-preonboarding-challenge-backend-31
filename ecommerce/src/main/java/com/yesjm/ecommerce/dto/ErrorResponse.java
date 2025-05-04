package com.yesjm.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private boolean success;
    private ErrorDetails error;

    public ErrorResponse(boolean success, ErrorDetails error) {
        this.success = success;
        this.error = error;
    }

    @Getter
    @Setter
    public static class ErrorDetails {
        private String code;
        private String message;
        private Map<String, Object> details;

        public ErrorDetails(String code, String message, Map<String, Object> details) {
            this.code = code;
            this.message = message;
            this.details = details;
        }

    }
}