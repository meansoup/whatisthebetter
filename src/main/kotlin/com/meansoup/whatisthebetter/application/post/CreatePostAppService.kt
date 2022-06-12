package com.meansoup.whatisthebetter.application.post

import com.meansoup.whatisthebetter.application.port.`in`.CreatePostUsecase
import org.springframework.stereotype.Service

@Service
class CreatePostAppService : CreatePostUsecase {
    override fun execute(
        uid: String,
        postTitle: String,
        content1Title: String,
        content1Description: String,
        content2Title: String,
        content2Description: String
    ) {
        TODO("Not yet implemented")
    }
}