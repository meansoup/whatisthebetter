package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.Content
import com.meansoup.whatisthebetter.domain.user.User

class Like {
    var user: User
    var thing: Content
    val createdAt: Long

    constructor(user: User, thing: Content) {
        this.user = user
        this.thing = thing
        this.createdAt = System.currentTimeMillis()
    }
}