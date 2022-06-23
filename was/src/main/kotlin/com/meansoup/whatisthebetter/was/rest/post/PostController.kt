package com.meansoup.whatisthebetter.was.rest.post

import com.meansoup.whatisthebetter.application.port.`in`.post.CreatePostUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class PostController @Autowired constructor(
    private val createPostUseCase: CreatePostUseCase
) {

    @PostMapping("/v1/post")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun createPost(@RequestParam uid: String, @RequestBody body: CreatePostRequest) {
        createPostUseCase.execute(
            uid,
            body.title,
            body.content1.title,
            body.content1.description,
            body.content2.title,
            body.content2.description
        )
    }
}