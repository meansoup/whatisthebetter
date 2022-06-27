package com.meansoup.whatisthebetter.application.port.out.user.mysql

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class MysqlUser {

    @Id
    var id: String? = null

    @Column
    var name: String? = null

    @Column
    var email: String? = null

    @Column
    var createdAt: Long? = null

    constructor(id: String?, name: String?, email: String?, createdAt: Long?) {
        this.id = id
        this.name = name
        this.email = email
        this.createdAt = createdAt
    }

    constructor()
}