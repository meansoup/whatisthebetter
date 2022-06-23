package com.meansoup.whatisthebetter.was.rest.post

import com.meansoup.whatisthebetter.application.port.`in`.post.GetPostUseCase
import com.meansoup.whatisthebetter.application.post.GetPostDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GetPostController @Autowired constructor(
    private val getPostUseCase: GetPostUseCase
) {

    @GetMapping("/v1/post", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPost(@RequestParam postId: String): GetPostResponse {
        val getPostDto = getPostUseCase.execute(postId)
        return GetPostResponse(getPostDto)
    }
}

class GetPostResponse(
    val id: String,
    var ownerUsername: String,
    var title: String,
    var content1Title: String,
    var content1Description: String,
    var content2Title: String,
    var content2Description: String,
    var createdAt: Long,
    var modifiedAt: Long,
    var likeCnt: Long
) {
    constructor(getPostDto: GetPostDto):
            this(
                getPostDto.id,
                getPostDto.ownerUsername,
                getPostDto.title,
                getPostDto.content1Title,
                getPostDto.content1Description,
                getPostDto.content2Title,
                getPostDto.content2Description,
                getPostDto.createdAt,
                getPostDto.modifiedAt,
                getPostDto.likeCnt
            )
}