package com.meansoup.whatisthebetter.was.rest.user

import org.apache.commons.lang3.RandomStringUtils
import org.jeasy.random.EasyRandom

class JoinRequestMother {
    companion object {
        private val easyRandom: EasyRandom = EasyRandom()

        fun generate(): JoinRequest {
            return JoinRequest(
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphanumeric(10) + ".com"
            )
        }
    }
}