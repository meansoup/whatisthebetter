package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.user.User

class Like {
    var user: User
    var thing: Likeable
    val createdAt: Long

    constructor(user: User, thing: Likeable) {
        this.user = user
        this.thing = thing
        this.createdAt = System.currentTimeMillis()
    }
}