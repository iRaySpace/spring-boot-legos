package com.example.demo.model

import jakarta.validation.constraints.Size


data class Staff(

    var id: Long,

    @field:Size(min=2, max=50)
    var firstName: String,

    @field:Size(min=2, max=50)
    var lastName: String,

)
