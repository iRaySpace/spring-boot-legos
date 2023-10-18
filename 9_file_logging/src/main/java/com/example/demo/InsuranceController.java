package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;
    @PostMapping("/check")
    public InsuranceCheck check(@RequestBody InsuranceCheckRequest insuranceCheckRequest) throws RuntimeException {
        return insuranceService.check(insuranceCheckRequest);
    }
}
