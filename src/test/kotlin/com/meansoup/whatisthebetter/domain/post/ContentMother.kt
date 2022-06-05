package com.meansoup.whatisthebetter.domain.post

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class ContentMother {

    companion object {
        private val parameters = EasyRandomParameters().seed(System.currentTimeMillis())
        private val easyRandom: EasyRandom = EasyRandom(parameters)

        fun generate(): Content {
            return easyRandom.nextObject(Content::class.java)
        }
    }
}