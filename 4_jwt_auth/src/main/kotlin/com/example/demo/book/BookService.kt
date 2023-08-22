package com.example.demo.book

import org.springframework.stereotype.Service
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.authority.SimpleGrantedAuthority


@Service
class BookService {
    fun get(): List<String> {
        val authentication = SecurityContextHolder.getContext().getAuthentication()
        val isTeacher = authentication.getAuthorities().contains(SimpleGrantedAuthority("ROLE_TEACHER"))
        if (isTeacher) {
            return listOf("Zero To Production In Rust")
        }
        return listOf()
    }
}
