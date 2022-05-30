package com.meansoup.whatisthebetter.domain.post

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class TargetMother {

    companion object {
        private val parameters = EasyRandomParameters().seed(System.currentTimeMillis())
        private val easyRandom: EasyRandom = EasyRandom(parameters)

        fun generate(): Target {
            return easyRandom.nextObject(Target::class.java)
        }
    }
}