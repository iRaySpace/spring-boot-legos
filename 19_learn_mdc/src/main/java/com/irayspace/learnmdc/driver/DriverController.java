package com.irayspace.learnmdc.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {
    
    private static final Logger LOG = LoggerFactory.getLogger(DriverController.class);

    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable String id) {
        final Driver driver = new Driver();
        driver.setFirstName(id);
        driver.setLastName(id);
        LOG.info("{}", driver);
        return driver;
    }

}
