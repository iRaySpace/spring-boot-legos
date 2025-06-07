package com.irayspace.learnecslog

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping
class PageController {

    @GetMapping
    fun getIndex() = Page(title = "index", content = "hello, world!")

}