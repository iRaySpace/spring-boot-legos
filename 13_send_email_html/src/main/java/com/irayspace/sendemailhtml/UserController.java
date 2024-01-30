package com.irayspace.sendemailhtml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody ResetPasswordRequest request) throws Exception {
        userService.resetPassword(request);
        return "Email sent successfully!";
    }
    
}
