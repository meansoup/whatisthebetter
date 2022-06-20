package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LikeService @Autowired constructor(
    private val likeRepository: LikeRepository
) {

    fun like(user: User, thing: Likeable) {
        val like = Like(user, thing)
        likeRepository.save(like)
    }
}