package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.CONFLICT)
public class DemoUnableToDeleteException extends RuntimeException {
    public DemoUnableToDeleteException(String id) {
        super(String.format("Unable to delete Demo %s", id));
    }
}
