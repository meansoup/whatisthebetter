package com.meansoup.whatisthebetter.application.port.out.like

import com.meansoup.whatisthebetter.domain.like.Like
import com.meansoup.whatisthebetter.domain.like.LikeRepository
import com.meansoup.whatisthebetter.domain.like.Likeable
import org.springframework.stereotype.Repository

@Repository
class LikeRepositoryImpl: LikeRepository {

    override fun save(like: Like) {
        TODO("Not yet implemented")
    }

    override fun findAllCntOf(likeable: Likeable): Long {
        TODO("Not yet implemented")
    }
}