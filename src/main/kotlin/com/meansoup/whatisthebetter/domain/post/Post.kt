package com.meansoup.whatisthebetter.domain.post

class Post {
    val id: String
    var title: Title
    var target1: Target
    var target2: Target
    var createdAt: Long
    var modifiedAt: Long

    constructor(id: String, title: Title, target1: Target, target2: Target) {
        this.id = id
        this.title = title
        this.target1 = target1
        this.target2 = target2

        val currentTime = System.currentTimeMillis()
        this.createdAt = currentTime
        this.modifiedAt = currentTime
    }
}