package com.meansoup.whatisthebetter.domain.user

class User {
    val name: Username
    val email: Email
    val createdAt: Long

    constructor(name: Username, email: Email) {
        this.name = name
        this.email = email

        val currentTime = System.currentTimeMillis()
        this.createdAt = currentTime
    }
}