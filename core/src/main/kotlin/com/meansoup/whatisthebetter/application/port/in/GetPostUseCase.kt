package com.meansoup.whatisthebetter.application.port.`in`

import com.meansoup.whatisthebetter.application.post.GetPostDto

interface GetPostUseCase {
    fun execute(postId: String): GetPostDto
}