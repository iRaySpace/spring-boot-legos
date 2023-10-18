package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    private static final String INVALID_USER_ID = "INVALID_USER_ID";

    private static Logger logger = LoggerFactory.getLogger(InsuranceService.class);

    public InsuranceCheck check(InsuranceCheckRequest insuranceCheckRequest) throws RuntimeException {
        boolean eligible = true;
        if (insuranceCheckRequest.getUserId().contentEquals(INVALID_USER_ID)) {
            logger.warn(String.format("Not eligible for insurance. User %s", INVALID_USER_ID));
            eligible = false;
        }
        return new InsuranceCheck(insuranceCheckRequest.getUserId(), eligible);
    }
}
