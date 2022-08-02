package com.meansoup.whatisthebetter.was.rest.post

import com.meansoup.whatisthebetter.application.port.`in`.post.CreatePostUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class CreatePostController @Autowired constructor(
    private val createPostUseCase: CreatePostUseCase
) {

    @PostMapping("/v1/post")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun createPost(@RequestHeader uid: String, @RequestBody body: CreatePostRequest): CreatePostResponse {
        val post = createPostUseCase.execute(
            uid,
            body.title,
            body.content1.title,
            body.content1.description,
            body.content2.title,
            body.content2.description
        )

        return CreatePostResponse(post.id.toString(), post.title.name)
    }
}

data class CreatePostRequest(val title: String, val content1: ContentRequest, val content2: ContentRequest)
data class ContentRequest(val title: String, val description: String)

data class CreatePostResponse(val postId: String, val title: String)