package com.meansoup.whatisthebetter.domain.user

import com.meansoup.whatisthebetter.domain.exception.InvalidEmailException
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class EmailTest {

    @Test
    fun `it throws error if email doesn't contain @`() {

        // given
        var name = RandomStringUtils.randomAlphanumeric(10)

        // when & then
        assertThrows(InvalidEmailException::class.java) {
            Email(name)
        }
    }

    @CsvSource(
        "username.@domain.com",
        ".user.name@domain.com",
        "user-name@domain.com.",
        "username@.com"
    )
    @ParameterizedTest
    fun `it throws error if invalid email`(name: String) {
        // when & then
        assertThrows(InvalidEmailException::class.java) {
            Email(name)
        }
    }

    @CsvSource(
        "username@domain.com",
        "user.name@domain.com",
        "user-name@domain.com",
        "username@domain.co.in",
        "user_name@domain.com"
    )
    @ParameterizedTest
    fun `it success to create Email`(name: String) {
        // when & then
        Email(name)
    }

}
