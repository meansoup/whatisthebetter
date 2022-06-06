package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.Content
import com.meansoup.whatisthebetter.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LikeService @Autowired constructor(
    private val likeRepository: LikeRepository
) {

    fun like(user: User, content: Content) {
        val like = Like(user, content)
        likeRepository.save(like)
    }
}