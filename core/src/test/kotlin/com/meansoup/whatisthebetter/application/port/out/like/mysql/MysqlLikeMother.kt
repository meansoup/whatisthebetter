package com.meansoup.whatisthebetter.application.port.out.like.mysql

import com.meansoup.whatisthebetter.adapter.out.mysql.like.MysqlLike
import com.meansoup.whatisthebetter.adapter.out.mysql.like.MysqlLikeFactory
import com.meansoup.whatisthebetter.domain.like.LikeMother

class MysqlLikeMother {
    companion object {
        fun generatePost(): MysqlLike {
            val likePost = LikeMother.generatePost()
            return MysqlLikeFactory.create(likePost)
        }

        fun generatePost(likedId: String): MysqlLike {
            val likePost = LikeMother.generatePost()
            return MysqlLike(likePost.user.id.toString(), likedId, likePost.createdAt)
        }

    }
}