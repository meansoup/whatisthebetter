package com.meansoup.whatisthebetter.domain.user

import org.apache.commons.lang3.RandomStringUtils

class UsernameMother {

    companion object {
        fun generate(): Username {
            val name = RandomStringUtils.randomAlphanumeric(10)
            return Username(name)
        }
    }
}