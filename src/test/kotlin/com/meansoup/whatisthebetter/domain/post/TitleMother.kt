package com.meansoup.whatisthebetter.domain.post

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class TitleMother {
    companion object {
        private val parameters = EasyRandomParameters().seed(System.currentTimeMillis())
        private val easyRandom: EasyRandom = EasyRandom(parameters)

        fun generate(): Title {
            return easyRandom.nextObject(Title::class.java)
        }
    }
}
