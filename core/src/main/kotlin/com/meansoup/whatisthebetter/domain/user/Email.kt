package com.meansoup.whatisthebetter.domain.user

import com.meansoup.whatisthebetter.domain.exception.InvalidEmailException
import java.util.regex.Pattern

data class Email(val name: String) {

    companion object {
        val REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" +
                "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
    }

    init {
        if (!isEmailPattern(name)) {
            throw InvalidEmailException(name)
        }
    }

    private fun isEmailPattern(name: String) = Pattern.compile(REGEX_PATTERN)
        .matcher(name)
        .matches()

}