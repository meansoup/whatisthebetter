package com.meansoup.whatisthebetter.application.port.out.user

import com.meansoup.whatisthebetter.domain.user.User
import com.meansoup.whatisthebetter.domain.user.UserRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepositoryImpl: UserRepository {

    override fun findBy(uid: UUID): User {
        TODO("Not yet implemented")
    }

    override fun save(user: User) {
        TODO("Not yet implemented")
    }
}