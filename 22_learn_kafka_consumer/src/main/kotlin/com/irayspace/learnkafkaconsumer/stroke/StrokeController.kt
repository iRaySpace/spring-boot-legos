package com.irayspace.learnkafkaconsumer.stroke

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class StrokeController(private val aggregator: StrokeAggregator) {

    @GetMapping("/analytics")
    fun getAnalytics() = aggregator.snapshot()

}