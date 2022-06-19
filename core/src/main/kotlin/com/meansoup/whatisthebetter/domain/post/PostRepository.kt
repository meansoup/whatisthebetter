package com.meansoup.whatisthebetter.domain.post

import java.util.*

interface PostRepository {
    fun save(post: Post)
    fun findBy(id: UUID): Post
}