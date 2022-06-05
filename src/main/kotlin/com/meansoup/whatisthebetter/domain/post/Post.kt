package com.meansoup.whatisthebetter.domain.post

class Post {
    val id: String
    var title: Title
    var content1: Content
    var content2: Content
    var createdAt: Long
    var modifiedAt: Long

    constructor(id: String, title: Title, content1: Content, content2: Content) {
        this.id = id
        this.title = title
        this.content1 = content1
        this.content2 = content2

        val currentTime = System.currentTimeMillis()
        this.createdAt = currentTime
        this.modifiedAt = currentTime
    }
}