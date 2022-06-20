package com.meansoup.whatisthebetter.domain.post

import com.meansoup.whatisthebetter.domain.like.Likeable
import com.meansoup.whatisthebetter.domain.user.User
import java.util.*

class Post: Likeable {
    val id: UUID
    var owner: User
    var title: Title
    var content1: Content
    var content2: Content
    var createdAt: Long
    var modifiedAt: Long

    constructor(owner: User, title: Title, content1: Content, content2: Content) {
        this.id = UUID.randomUUID()
        this.owner = owner
        this.title = title
        this.content1 = content1
        this.content2 = content2

        val currentTime = System.currentTimeMillis()
        this.createdAt = currentTime
        this.modifiedAt = currentTime
    }
}
