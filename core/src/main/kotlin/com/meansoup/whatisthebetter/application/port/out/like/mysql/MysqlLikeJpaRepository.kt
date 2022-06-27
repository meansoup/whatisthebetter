package com.meansoup.whatisthebetter.application.port.out.like.mysql

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MysqlLikeJpaRepository : JpaRepository<MysqlLike, MysqlLikeId> {
    fun countByLikedId(likedId: String): Long
}