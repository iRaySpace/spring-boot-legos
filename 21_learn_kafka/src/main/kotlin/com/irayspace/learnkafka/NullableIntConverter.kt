package com.irayspace.learnkafka

import com.opencsv.bean.AbstractBeanField


class NullableIntConverter : AbstractBeanField<String, Int?>() {
    override fun convert(value: String): Int? {
        return value.toIntOrNull()
    }
}
