package com.meansoup.whatisthebetter.application.port.out.post

import com.meansoup.whatisthebetter.domain.post.Post
import com.meansoup.whatisthebetter.domain.post.PostRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PostRepositoryImpl: PostRepository {

    override fun save(post: Post) {
        TODO("Not yet implemented")
    }

    override fun findBy(id: UUID): Post {
        TODO("Not yet implemented")
    }
}