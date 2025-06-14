package com.irayspace.learnkafka

import java.io.FileReader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate

import com.opencsv.CSVReaderBuilder
import com.opencsv.bean.CsvToBeanBuilder

import com.fasterxml.jackson.databind.ObjectMapper


@SpringBootApplication
class LearnkafkaApplication {

	@Bean
	fun run(objectMapper: ObjectMapper, kafkaTemplate: KafkaTemplate<String, String>) = CommandLineRunner {
		val reader = CSVReaderBuilder(FileReader("stroke-data.csv"))
			.withSkipLines(1)
			.build()

		val beans: List<StrokeData> = CsvToBeanBuilder<StrokeData>(reader)
			.withType(StrokeData::class.java)
			.build()
			.parse()

		beans.forEach { line ->
			val jsonData = objectMapper.writeValueAsString(line)
			kafkaTemplate.send("stroke-events", jsonData)
		}
	}

}
fun main(args: Array<String>) {
	runApplication<LearnkafkaApplication>(*args)
}
