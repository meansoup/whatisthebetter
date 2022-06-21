package com.meansoup.whatisthebetter.application.port.`in`

interface LikePostUseCase {
    fun execute(uid: String, postId: String)
}