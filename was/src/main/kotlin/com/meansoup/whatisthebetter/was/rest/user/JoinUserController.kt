package com.meansoup.whatisthebetter.was.rest.user

import com.meansoup.whatisthebetter.application.port.`in`.user.JoinUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class JoinUserController @Autowired constructor(
    private val joinUseCase: JoinUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/user", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPost(@RequestBody joinRequest: JoinRequest): JoinResponse {
        val user = joinUseCase.execute(joinRequest.name, joinRequest.email)

        return JoinResponse(user.id.toString(), user.name.name, user.email.name)
    }
}

data class JoinRequest(val name: String, val email: String)
data class JoinResponse(val userId: String, val name: String, val email: String)