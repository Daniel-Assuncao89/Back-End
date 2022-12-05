package org.soulcodeacademy.empresa.controller.errors;

import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

public class CustomErrorResponse {

    private String message;

    private Integer status;

    private LocalDateTime timestamp;

    private String path;

    private List<FieldError> fieldErrorList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<FieldError> getFieldErrorList() {
        return fieldErrorList;
    }

    public void setFieldErrorList(List<FieldError> fieldErrorList) {
        this.fieldErrorList = fieldErrorList;
    }
}
