package com.irayspace.learnkafka

import com.opencsv.bean.AbstractBeanField


class NullableFloatConverter : AbstractBeanField<String, Float?>() {
    override fun convert(value: String): Float? {
        return value.toFloatOrNull()
    }
}