package com.example.demo.Item

import jakarta.validation.constraints.Size
import jakarta.validation.constraints.Min
import java.math.BigDecimal


data class Item(
    // Never forget the `field` in the annotation
    @field:Size(min = 2, max = 5)
    val name: String,

    val description: String,

    @field:Min(0)
    val rate: BigDecimal,
)
