package com.irayspace.learnsqs.submitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.services.sqs.SqsClient;

@RestController
@RequestMapping("/submitter")
public class SubmitterController {

    @Autowired
    private SubmitterService submitterService;

    @GetMapping
    public String getSubmitter() {
        return "Hello, world!";
    }

    @PostMapping
    public String postSubmitter(@RequestBody SubmitterRequest submitterRequest) {
        submitterService.sendMessage(submitterRequest);
        return "Your message: " + submitterRequest.message();
    }

}
