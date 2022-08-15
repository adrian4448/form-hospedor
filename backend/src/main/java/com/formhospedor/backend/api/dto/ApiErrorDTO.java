package com.formhospedor.backend.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiErrorDTO {

    private List<String> errors;

    public ApiErrorDTO(String message) {
        this.errors.add(message);
    }

}
