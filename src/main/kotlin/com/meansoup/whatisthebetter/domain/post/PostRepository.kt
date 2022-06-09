package com.meansoup.whatisthebetter.domain.post

interface PostRepository {
    fun save(post: Post)
}