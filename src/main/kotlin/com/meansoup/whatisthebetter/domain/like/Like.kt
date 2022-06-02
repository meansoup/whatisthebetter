package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.Post
import com.meansoup.whatisthebetter.domain.user.User

class Like {
    var user: User
    var thing: Post
    val createdAt: Long

    constructor(user: User, thing: Post) {
        this.user = user
        this.thing = thing
        this.createdAt = System.currentTimeMillis()
    }
}