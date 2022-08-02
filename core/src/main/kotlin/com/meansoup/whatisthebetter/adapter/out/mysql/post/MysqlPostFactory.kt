package com.meansoup.whatisthebetter.adapter.out.mysql.post

import com.meansoup.whatisthebetter.domain.exception.NullPropertyException
import com.meansoup.whatisthebetter.domain.post.Content
import com.meansoup.whatisthebetter.domain.post.Post
import com.meansoup.whatisthebetter.domain.post.Title
import java.util.*

class MysqlPostFactory {

    companion object {
        fun create(post: Post): MysqlPost {
            return MysqlPost(
                post.id.toString(),
                post.userId.toString(),
                post.title.name,
                post.content1.title,
                post.content1.description,
                post.content2.title,
                post.content2.description,
                post.createdAt,
                post.modifiedAt
            )
        }

        fun create(mysqlPost: MysqlPost): Post {
            val title = mysqlPost.title ?: throw NullPropertyException("title is null in: " + mysqlPost.id)

            val content1Title = mysqlPost.content1Title ?: throw NullPropertyException("content1Title is null in: " + mysqlPost.id)
            val content1Description = mysqlPost.content1Description ?: throw NullPropertyException("content1Description is null in: " + mysqlPost.id)

            val content2Title = mysqlPost.content2Title ?: throw NullPropertyException("content2Title is null in: " + mysqlPost.id)
            val content2Description = mysqlPost.content2Description ?: throw NullPropertyException("content2Description is null in: " + mysqlPost.id)

            val createdAt = mysqlPost.createdAt ?: throw NullPropertyException("createdAt is null in: " + mysqlPost.id)
            val modifiedAt = mysqlPost.modifiedAt ?: throw NullPropertyException("modifiedAt is null in: " + mysqlPost.id)

            return Post(
                UUID.fromString(mysqlPost.id),
                UUID.fromString(mysqlPost.userId),
                Title(title),
                Content(content1Title, content1Description),
                Content(content2Title, content2Description),
                createdAt,
                modifiedAt
            )
        }
    }
}