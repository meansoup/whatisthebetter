package com.meansoup.whatisthebetter.domain.post

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService @Autowired constructor(
    private val postRepository: PostRepository
) {

    fun createPost(post: Post) {
        postRepository.save(post)
    }

    fun getPost(id: UUID): Post {
        return postRepository.findBy(id)
    }
}