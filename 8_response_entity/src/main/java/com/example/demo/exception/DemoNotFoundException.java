package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DemoNotFoundException extends RuntimeException {
    public DemoNotFoundException(String id) {
        super(String.format("Demo %s not found", id));
    }
}
