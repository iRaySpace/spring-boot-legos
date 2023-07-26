package com.irayspace.hello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping

@SpringBootApplication
class HelloApplication

fun main(args: Array<String>) {
	runApplication<HelloApplication>(*args)
}

@RestController
class MessageController {
	@GetMapping("/")
	fun index(@RequestParam("name") name: String) = "Hello, $name!"

	@GetMapping("/hello")
	fun hello() = listOf(
		Hello("1", "Hello!"),
		Hello("2", "Bonjour!"),
		Hello("3", "Privet!"),
	)

	@PostMapping("/hello")
	fun helloPost(@RequestBody hello: Hello) {
		println(hello)
	}
}

data class Hello(val id: String?, val text: String)