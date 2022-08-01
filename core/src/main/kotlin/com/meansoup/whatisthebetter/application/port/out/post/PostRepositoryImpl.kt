package com.meansoup.whatisthebetter.application.port.out.post

import com.meansoup.whatisthebetter.application.port.out.post.mysql.MysqlPostFactory
import com.meansoup.whatisthebetter.application.port.out.post.mysql.MysqlPostJpaRepository
import com.meansoup.whatisthebetter.domain.exception.ResourceNotExistException
import com.meansoup.whatisthebetter.domain.post.Post
import com.meansoup.whatisthebetter.domain.post.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PostRepositoryImpl @Autowired constructor(
    private val mysqlPostJpaRepository: MysqlPostJpaRepository
): PostRepository {

    override fun save(post: Post) {
        val mysqlPost = MysqlPostFactory.create(post)
        mysqlPostJpaRepository.save(mysqlPost)
    }

    override fun findBy(id: UUID): Post {
        val found = mysqlPostJpaRepository.findByIdOrNull(id.toString())

        found?: throw ResourceNotExistException("Post not exist: $id")

        return MysqlPostFactory.create(found)
    }
}