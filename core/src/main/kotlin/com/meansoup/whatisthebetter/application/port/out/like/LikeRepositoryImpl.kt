package com.meansoup.whatisthebetter.application.port.out.like

import com.meansoup.whatisthebetter.application.exception.InvalidTypeException
import com.meansoup.whatisthebetter.application.port.out.like.mysql.MysqlLikeDtoJpaRepository
import com.meansoup.whatisthebetter.application.port.out.like.mysql.MysqlLikeFactory
import com.meansoup.whatisthebetter.domain.like.Like
import com.meansoup.whatisthebetter.domain.like.LikeRepository
import com.meansoup.whatisthebetter.domain.like.Likeable
import com.meansoup.whatisthebetter.domain.post.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class LikeRepositoryImpl @Autowired constructor(
    private val mysqlLikeDtoJpaRepository: MysqlLikeDtoJpaRepository
): LikeRepository {

    override fun save(like: Like) {
        val mysqlLike = MysqlLikeFactory.create(like)
        mysqlLikeDtoJpaRepository.save(mysqlLike)
    }

    override fun findAllCntOf(likeable: Likeable): Long {
        val likedId = likedIdOf(likeable)
        return mysqlLikeDtoJpaRepository.countByLikedId(likedId)
    }

    fun likedIdOf(likeable: Likeable): String {
        when (likeable) {
            is Post -> return likeable.id.toString()
            else -> throw InvalidTypeException("unknown likeable type")
        }
    }
}