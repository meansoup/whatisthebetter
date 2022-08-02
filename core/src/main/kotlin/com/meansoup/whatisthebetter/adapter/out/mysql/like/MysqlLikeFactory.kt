package com.meansoup.whatisthebetter.adapter.out.mysql.like

import com.meansoup.whatisthebetter.domain.like.Like
import com.meansoup.whatisthebetter.domain.post.Post

class MysqlLikeFactory {

    companion object {
        fun create(like: Like): MysqlLike {
            val userId = like.user.id.toString()
            val postId = (like.thing as Post).id.toString()
            val createdAt = like.createdAt

            return MysqlLike(userId, postId, createdAt)
        }
    }
}