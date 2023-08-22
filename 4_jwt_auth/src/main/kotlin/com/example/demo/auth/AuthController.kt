package com.example.demo.auth

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.security.authentication.AuthenticationManager


@RestController
@RequestMapping("authenticate")
class AuthController(val authService: AuthService) {

    @PostMapping
    fun login(@RequestBody data: AuthDto): TokenDto = authService.authenticate(data)
}
