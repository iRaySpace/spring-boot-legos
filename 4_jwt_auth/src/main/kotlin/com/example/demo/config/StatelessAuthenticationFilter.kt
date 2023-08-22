package com.example.demo.config

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.context.SecurityContextHolder

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletRequest

import com.example.demo.auth.AuthToken

class StatelessAuthenticationFilter(
    val authManager: AuthenticationManager,
    val userDetailsService: UserDetailsService,
    val secret: String,
) : BasicAuthenticationFilter(authManager) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        setAuthenticationFromHeader(request)
        chain.doFilter(request, response)
    }

    fun setAuthenticationFromHeader(request: HttpServletRequest) {
        val authorization = request.getHeader("Authorization")
        if (authorization != null && !authorization.isEmpty()) {
            val token = authorization.removePrefix("Bearer ")
            val username = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.toByteArray()))
                .build()
                .parseClaimsJws(token)
                .body
                .subject
            val userDetails = userDetailsService.loadUserByUsername(username)
            SecurityContextHolder.getContext().authentication = AuthToken(userDetails, token)
        }
    }
}