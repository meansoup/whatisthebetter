package com.meansoup.whatisthebetter.application.port.`in`.user

interface JoinUseCase {
    fun execute(name: String, email: String)
}