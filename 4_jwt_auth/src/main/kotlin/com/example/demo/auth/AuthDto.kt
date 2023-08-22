package com.example.demo.auth


data class AuthDto(
    val username: String,
    val password: String,
)

data class TokenDto(
    val token: String,
)
