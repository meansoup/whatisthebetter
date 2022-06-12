package com.meansoup.whatisthebetter.application.port.`in`

interface CreatePostUsecase {
    fun execute(
        uid: String, postTitle: String,
        content1Title: String, content1Description: String,
        content2Title: String, content2Description: String
    )
}