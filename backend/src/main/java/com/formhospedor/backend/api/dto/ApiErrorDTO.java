package com.formhospedor.backend.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiErrorDTO {

    private List<String> errors = new ArrayList<>();

    public ApiErrorDTO(String message) {
        this.errors.add(message);
    }

}
