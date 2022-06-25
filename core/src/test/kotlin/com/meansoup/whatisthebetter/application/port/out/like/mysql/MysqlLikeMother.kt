package com.meansoup.whatisthebetter.application.port.out.like.mysql

import com.meansoup.whatisthebetter.domain.like.LikeMother
import com.meansoup.whatisthebetter.domain.post.Post
import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class MysqlLikeMother {
    companion object {
        private val parameters = EasyRandomParameters().seed(System.currentTimeMillis())
        private val easyRandom: EasyRandom = EasyRandom(parameters)

        fun generatePost(): MysqlLike {
            val likePost = LikeMother.generatePost()
            val post = likePost.thing

            val likedId = when (post) {
                is Post -> post.id.toString()
                else -> ""
            }

            return MysqlLike(likePost.user.id.toString(), likedId, likePost.createdAt)
        }

    }
}