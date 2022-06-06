package com.meansoup.whatisthebetter.domain.like

interface LikeRepository {
    fun save(like: Like)
}