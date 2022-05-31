package com.meansoup.whatisthebetter.domain.user

import org.apache.commons.lang3.RandomStringUtils

class EmailMother {

    companion object {
        fun generate(): Email {
            val emailId = RandomStringUtils.randomAlphanumeric(10)
            val subDomain = RandomStringUtils.randomAlphabetic(10)
            val tlbDomain = RandomStringUtils.randomAlphabetic(3)

            val emailName = String.format("%s@%s.%s", emailId, subDomain, tlbDomain)

            return Email(emailName)
        }
    }
}