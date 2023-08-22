package com.example.demo.book

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.authority.SimpleGrantedAuthority


@RestController
@RequestMapping("book")
class BookController(val bookService: BookService) {

    @GetMapping
    fun get(): List<String> = bookService.get()
}
