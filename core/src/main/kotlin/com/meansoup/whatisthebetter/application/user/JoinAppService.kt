package com.meansoup.whatisthebetter.application.user

import com.meansoup.whatisthebetter.application.port.`in`.user.JoinUseCase
import com.meansoup.whatisthebetter.domain.user.Email
import com.meansoup.whatisthebetter.domain.user.User
import com.meansoup.whatisthebetter.domain.user.UserService
import com.meansoup.whatisthebetter.domain.user.Username
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class JoinAppService @Autowired constructor(
    private val userService: UserService
): JoinUseCase {

    override fun execute(name: String, email: String) {
        val user = User(Username(name), Email(email))
        userService.createUser(user)
    }
}