package com.irayspace.learnratelimiter.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irayspace.learnratelimiter.ratelimiter.RateLimiter;
import com.irayspace.learnratelimiter.ratelimiter.RateLimiterService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/student")
public class StudentController {

    @RateLimiter
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id, HttpServletRequest request) {
        return new Student(id, "Ivan", "Ivanov", "Ivanovich");
    }

}
