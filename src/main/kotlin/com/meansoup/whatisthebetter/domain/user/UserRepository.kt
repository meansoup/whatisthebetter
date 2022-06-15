package com.meansoup.whatisthebetter.domain.user

import java.util.*

interface UserRepository {
    fun findBy(uid: UUID): User
}