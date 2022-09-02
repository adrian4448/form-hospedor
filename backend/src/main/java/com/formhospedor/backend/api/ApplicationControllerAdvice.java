package com.formhospedor.backend.api;

import com.formhospedor.backend.api.dto.ApiErrorDTO;
import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorDTO handleBusinessException(BusinessException exception) {
        return new ApiErrorDTO(exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorDTO handleNotFoundException(NotFoundException exception) {
        return new ApiErrorDTO(exception.getMessage());
    }

}
