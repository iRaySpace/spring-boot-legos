package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.CONFLICT)
public class DemoAlreadyExistsException extends RuntimeException {
    public DemoAlreadyExistsException(String title) {
        super(String.format("Demo {title = %s} already exists", title));
    }
}
