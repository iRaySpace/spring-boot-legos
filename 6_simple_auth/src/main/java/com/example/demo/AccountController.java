package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        return accountService.register(account);
    }

    @PostMapping("/auth")
    public String login(@RequestBody Account account) throws Exception {
        accountService.login(account);
        return "OK";
    }
}
