package com.meansoup.whatisthebetter.domain.post

import com.meansoup.whatisthebetter.domain.user.User

class Post {
    val id: String
    var owner: User
    var title: Title
    var content1: Content
    var content2: Content
    var createdAt: Long
    var modifiedAt: Long

    constructor(id: String, owner: User, title: Title, content1: Content, content2: Content) {
        this.id = id
        this.owner = owner
        this.title = title
        this.content1 = content1
        this.content2 = content2

        val currentTime = System.currentTimeMillis()
        this.createdAt = currentTime
        this.modifiedAt = currentTime
    }
}
