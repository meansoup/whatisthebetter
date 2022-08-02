package com.meansoup.whatisthebetter.application.port.`in`.user

import com.meansoup.whatisthebetter.domain.user.User

interface JoinUseCase {
    fun execute(name: String, email: String): User
}