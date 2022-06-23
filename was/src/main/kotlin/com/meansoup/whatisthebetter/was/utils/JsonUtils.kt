package com.meansoup.whatisthebetter.was.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class JsonUtils {

    companion object {
        val mapper = jacksonObjectMapper()

        fun toJson(any: Any) = mapper.writeValueAsString(any)
        inline fun <reified T> toType(json: String): T = mapper.readValue(json)
    }
}