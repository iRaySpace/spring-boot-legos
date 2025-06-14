package com.irayspace.learnkafka

import com.opencsv.bean.AbstractBeanField


class BooleanFromIntConverter : AbstractBeanField<String, Boolean>() {
    override fun convert(value: String): Boolean {
        return value == "1"
    }
}
