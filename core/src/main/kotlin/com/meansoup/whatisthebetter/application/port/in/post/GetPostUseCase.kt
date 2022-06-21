package com.meansoup.whatisthebetter.application.port.`in`.post

import com.meansoup.whatisthebetter.application.post.GetPostDto

interface GetPostUseCase {
    fun execute(postId: String): GetPostDto
}