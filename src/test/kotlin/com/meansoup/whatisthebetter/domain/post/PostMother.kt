package com.meansoup.whatisthebetter.domain.post

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class PostMother {

    companion object {
        private val parameters = EasyRandomParameters().seed(System.currentTimeMillis())
        private val easyRandom: EasyRandom = EasyRandom(parameters)

        fun generate(): Post {
            return easyRandom.nextObject(Post::class.java)
        }
    }
}