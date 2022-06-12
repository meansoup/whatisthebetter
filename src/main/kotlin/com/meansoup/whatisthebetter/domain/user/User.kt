package com.meansoup.whatisthebetter.domain.user

import java.util.*

class User {
    val id: UUID
    val name: Username
    val email: Email
    val createdAt: Long

    constructor(name: Username, email: Email) {
        this.id = UUID.randomUUID()
        this.name = name
        this.email = email

        val currentTime = System.currentTimeMillis()
        this.createdAt = currentTime
    }
}