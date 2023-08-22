package com.example.demo.auth

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys

import java.util.Date


@Service
class AuthService(
    @param:Value("\${jwt.secret}")
    val secret: String,
    val authenticationManager: AuthenticationManager,
) {
    fun authenticate(data: AuthDto): TokenDto {
        val authToken = UsernamePasswordAuthenticationToken(data.username, data.password)
        val authenticated = authenticationManager.authenticate(authToken)
        val expiration = Date(System.currentTimeMillis() + 1000 * 300)
        val token = Jwts.builder()
            .setSubject(data.username)
            .setIssuedAt(Date())
            .setExpiration(expiration)
            .signWith(Keys.hmacShaKeyFor(secret.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
        return TokenDto(token)
    }
}
