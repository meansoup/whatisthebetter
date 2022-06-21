package com.meansoup.whatisthebetter.application.post

import com.meansoup.whatisthebetter.application.port.`in`.post.LikePostUseCase
import com.meansoup.whatisthebetter.domain.like.LikeService
import com.meansoup.whatisthebetter.domain.post.PostService
import com.meansoup.whatisthebetter.domain.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LikePostAppService @Autowired constructor(
    private val userRepository: UserRepository,
    private val postService: PostService,
    private val likeService: LikeService
): LikePostUseCase {

    override fun execute(uid: String, postId: String) {
        val user = userRepository.findBy(UUID.fromString(uid))
        val post = postService.getPost(UUID.fromString(postId))

        likeService.like(user, post)
    }
}