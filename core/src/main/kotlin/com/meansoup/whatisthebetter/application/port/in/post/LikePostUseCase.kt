package com.meansoup.whatisthebetter.application.port.`in`.post

interface LikePostUseCase {
    fun execute(uid: String, postId: String)
}