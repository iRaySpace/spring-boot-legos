package com.irayspace.learnkafkaconsumer.stroke

import org.springframework.stereotype.Component


@Component
class StrokeAggregator {

    private val genderCount = mutableMapOf<String, Long>()
    private val strokeCount = mutableMapOf<Boolean, Long>()
    private var ageTotal = 0.0
    private var records = 0

    fun process(data: Stroke) {
        genderCount.merge(data.gender, 1, Long::plus)
        strokeCount.merge(data.hasStroke, 1, Long::plus)
        ageTotal = ageTotal + data.age
        records = records + 1
    }

    fun snapshot(): Map<String, Any> = mapOf(
        "genderDistribution" to genderCount,
        "strokeDistribution" to strokeCount,
        "averageAge" to if (records > 0) ageTotal / records else 0.0,
        "records" to records
    )

}