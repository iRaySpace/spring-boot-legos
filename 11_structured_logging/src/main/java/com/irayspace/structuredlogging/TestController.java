package com.irayspace.structuredlogging;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
@RequestMapping("/log")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/error")
    public String error() {
        logger.error("This is an error message");
        return "Something went wrong";
    }

    @GetMapping("/warn")
    public String warn() {
        logger.warn("This is a warn message");
        return "Something went wrong";
    }

    @GetMapping("/info")
    public String info() {
        logger.info("This is an info message");
        return "Hello, world!";
    }
}
