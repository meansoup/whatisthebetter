package com.meansoup.whatisthebetter.was.rest.post

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class CreatePostRequestMother {
    companion object {
        private val parameters = EasyRandomParameters().seed(System.currentTimeMillis())
        private val easyRandom: EasyRandom = EasyRandom(parameters)

        fun generate(): CreatePostRequest {
            return easyRandom.nextObject(CreatePostRequest::class.java)
        }
    }
}