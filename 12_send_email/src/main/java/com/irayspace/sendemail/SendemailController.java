package com.irayspace.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/sendemail")
public class SendemailController {
    @Autowired
    private SendemailService sendemailService;

    @PostMapping
    public SendemailResponse send(@RequestBody SendemailRequest data) {
        sendemailService.send(data);
        return new SendemailResponse("Email sent!");
    }
    
}
