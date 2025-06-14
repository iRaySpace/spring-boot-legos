package com.irayspace.learnkafka

import com.opencsv.bean.CsvBindByPosition
import com.opencsv.bean.CsvCustomBindByPosition


data class StrokeData(

    @CsvBindByPosition(position = 0)
    var id: Long = -1,

    @CsvBindByPosition(position = 1)
    var gender: String = "",

    @CsvCustomBindByPosition(position = 2, converter = NullableIntConverter::class)
    var age: Int? = null,

    @CsvCustomBindByPosition(position = 3, converter = BooleanFromIntConverter::class)
    var hasHypertension: Boolean = false,

    @CsvCustomBindByPosition(position = 4, converter = BooleanFromIntConverter::class)
    var hasHeartDisease: Boolean = false,

    @CsvCustomBindByPosition(position = 5, converter = BooleanFromTextConverter::class)
    var hasEverMarried: Boolean = false,
    
    @CsvBindByPosition(position = 6)
    var workType: String = "",
    
    @CsvBindByPosition(position = 7)
    var residenceType: String = "",

    @CsvBindByPosition(position = 8)
    var avgGlucoseLevel: Float = 0.0f,

    @CsvCustomBindByPosition(position = 9, converter = NullableFloatConverter::class)
    var bmi: Float? = null,

    @CsvBindByPosition(position = 10)
    var smokingStatus: String = "",

    @CsvCustomBindByPosition(position = 11, converter = BooleanFromIntConverter::class)
    var hasStroke: Boolean = false

)
