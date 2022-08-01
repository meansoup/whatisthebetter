package com.meansoup.whatisthebetter.adapter.out.mysql.like

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "likes")
@IdClass(MysqlLikeId::class)
class MysqlLike {
    constructor(userId: String?, likedId: String?, createdAt: Long?) {
        this.userId = userId
        this.likedId = likedId
        this.createdAt = createdAt
    }

    constructor() {}

    @Id
    var userId: String? = null

    @Id
    var likedId: String? = null

    @Column
    var createdAt: Long? = null
}

class MysqlLikeId: Serializable {
    var userId: String? = null
    var likedId: String? = null

    constructor(userId: String?, likedId: String?) {
        this.userId = userId
        this.likedId = likedId
    }

    constructor() {}
}