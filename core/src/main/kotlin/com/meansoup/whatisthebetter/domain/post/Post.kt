package com.meansoup.whatisthebetter.domain.post

import com.meansoup.whatisthebetter.domain.like.Likeable
import java.util.*

class Post: Likeable {
    val id: UUID
    var userId: UUID
    var title: Title
    var content1: Content
    var content2: Content
    var createdAt: Long
    var modifiedAt: Long

    constructor(userId: UUID, title: Title, content1: Content, content2: Content) {
        this.id = UUID.randomUUID()
        this.userId = userId
        this.title = title
        this.content1 = content1
        this.content2 = content2

        val currentTime = System.currentTimeMillis()
        this.createdAt = currentTime
        this.modifiedAt = currentTime
    }

    constructor(id: UUID, userId: UUID, title: Title, content1: Content, content2: Content, createdAt: Long, modifiedAt: Long) {
        this.id = id
        this.userId = userId
        this.title = title
        this.content1 = content1
        this.content2 = content2
        this.createdAt = createdAt
        this.modifiedAt = modifiedAt
    }
}
