package com.meansoup.whatisthebetter.domain.post

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(
    private val postRepository: PostRepository
) {

    fun createPost(post: Post) {
        postRepository.save(post)
    }
}