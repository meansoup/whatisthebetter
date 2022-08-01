package com.meansoup.whatisthebetter.application.post

import com.meansoup.whatisthebetter.application.port.`in`.post.CreatePostUseCase
import com.meansoup.whatisthebetter.domain.post.Content
import com.meansoup.whatisthebetter.domain.post.Post
import com.meansoup.whatisthebetter.domain.post.PostService
import com.meansoup.whatisthebetter.domain.post.Title
import com.meansoup.whatisthebetter.domain.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreatePostAppService @Autowired constructor(
    private val userRepository: UserRepository,
    private val postService: PostService
): CreatePostUseCase {

    override fun execute(
        uid: String,
        postTitle: String,
        content1Title: String,
        content1Description: String,
        content2Title: String,
        content2Description: String
    ) {
        val userUuid = UUID.fromString(uid)
        val user = userRepository.findBy(userUuid)

        val post = Post(
            user.id,
            Title(postTitle),
            Content(content1Title, content1Description),
            Content(content2Title, content2Description)
        )

        postService.createPost(post)
    }
}