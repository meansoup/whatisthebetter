package com.meansoup.whatisthebetter.domain.user

import com.meansoup.whatisthebetter.domain.exception.InvalidCharacterInUsernameException
import com.meansoup.whatisthebetter.domain.exception.TooLongUsernameException
import com.meansoup.whatisthebetter.domain.exception.TooSmallUsernameException
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class UsernameTest {

    @ParameterizedTest
    @ValueSource(ints = [6, 15, 30])
    fun `alphanumeric name으로 Username이 잘 생성된다`(length: Int) {
        // given
        val name = RandomStringUtils.randomAlphanumeric(length)

        // when & then
        Username(name)
    }

    @ParameterizedTest
    @ValueSource(ints = [31, 100])
    fun `name이 30자리를 넘으면 TooLongUsernameException을 던진다`(length: Int) {
        // given
        val name = RandomStringUtils.randomAlphanumeric(length)

        // when & then
        assertThrows(TooLongUsernameException::class.java) {
            Username(name)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `name이 6자리보다 작으면 TooSmallUsernameException을 던진다`(length: Int) {
        // given
        val name = RandomStringUtils.randomAlphanumeric(length)

        // when & then
        assertThrows(TooSmallUsernameException::class.java) {
            Username(name)
        }
    }

    @CsvSource(
        "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "<", ">", ".",
        "/", "?", ":", ";", "'", "[", "]", "{", "}", "|"
    )
    @ParameterizedTest
    fun `name이 alphanumeric과 _- 공백 을 제외한 문자를 갖는다면 InvalidCharacterInUsernameException을 던진다`(specialChar: String) {
        // given
        var name = RandomStringUtils.randomAlphanumeric(10) + " _-" + specialChar

        // when & then
        assertThrows(InvalidCharacterInUsernameException::class.java) {
            Username(name)
        }
    }
}
