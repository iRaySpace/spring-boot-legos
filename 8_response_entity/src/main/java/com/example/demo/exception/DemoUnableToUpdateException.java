package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.CONFLICT)
public class DemoUnableToUpdateException extends RuntimeException {
    public DemoUnableToUpdateException(String id) {
        super(String.format("Unable to update Demo %s", id));
    }
}
