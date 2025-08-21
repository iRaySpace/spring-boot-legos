package com.irayspace.learnkafkaconsumer.stroke

import org.springframework.stereotype.Component
import org.springframework.kafka.annotation.KafkaListener

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue


@Component
class StrokeConsumer(
    private val aggregator: StrokeAggregator,
    private val objectMapper: ObjectMapper
) {

    @KafkaListener(topics = ["stroke-events"])
    fun listen(message: String) {
        val strokeData: Stroke = objectMapper.readValue(message)
        aggregator.process(strokeData)
    }

}