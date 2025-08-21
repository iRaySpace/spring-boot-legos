package com.irayspace.learnkafkaconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule


@SpringBootApplication
class LearnkafkaconsumerApplication

fun main(args: Array<String>) {
	runApplication<LearnkafkaconsumerApplication>(*args)
}
