package com.example.demo.Item

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import jakarta.validation.Valid


@CrossOrigin
@RestController
@RequestMapping("/item")
class ItemController {

    @GetMapping("")
    fun get(): List<Item> = listOf()

    @PostMapping("")
    fun create(@Valid @RequestBody item: Item): Item = item
}
