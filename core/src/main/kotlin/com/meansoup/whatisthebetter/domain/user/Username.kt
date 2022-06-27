package com.meansoup.whatisthebetter.domain.user

import com.meansoup.whatisthebetter.domain.exception.InvalidCharacterInUsernameException
import com.meansoup.whatisthebetter.domain.exception.TooLongUsernameException
import com.meansoup.whatisthebetter.domain.exception.TooSmallUsernameException

data class Username(val name: String) {

    init {
        if (name.length < 6) {
            throw TooSmallUsernameException(name)
        }

        if (name.length > 30) {
            throw TooLongUsernameException(name)
        }

        if (hasInvalidChar(name)) {
            throw InvalidCharacterInUsernameException(name)
        }
    }

    private fun hasInvalidChar(name: String): Boolean {
        for (c in name) {
            if (!Character.isLetterOrDigit(c) &&
                !Character.isWhitespace(c) &&
                !"-".equals(c) &&
                !"_".equals(c)) {
                return true
            }
        }

        return false
    }
}
