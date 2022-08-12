package com.formhospedor.backend.exceptions;

public class NotFoundException extends RuntimeException  {
    public NotFoundException(String msg) {
        super(msg);
    }
}
