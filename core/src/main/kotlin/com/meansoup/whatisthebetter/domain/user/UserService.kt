package com.meansoup.whatisthebetter.domain.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {

    fun createUser(user: User) {
        userRepository.save(user)
    }
}