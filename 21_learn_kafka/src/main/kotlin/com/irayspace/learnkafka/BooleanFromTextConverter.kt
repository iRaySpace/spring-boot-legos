package com.irayspace.learnkafka

import com.opencsv.bean.AbstractBeanField


class BooleanFromTextConverter : AbstractBeanField<String, Boolean>() {
    override fun convert(value: String): Boolean {
        return value.lowercase() == "yes"        
    }
}
