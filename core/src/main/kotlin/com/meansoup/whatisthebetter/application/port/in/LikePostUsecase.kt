package com.meansoup.whatisthebetter.application.port.`in`

interface LikePostUsecase {
    fun execute(uid: String, postId: String)
}