package com.meansoup.whatisthebetter.application.port.out.post.mysql

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "post")
class MysqlPost {

    var id: String? = null

    var userId: String? = null

    var title: String? = null

    var content1Title: String? = null
    var content1Description: String? = null

    var content2Title: String? = null
    var content2Description: String? = null

    var createdAt: Long? = null
    var modifiedAt: Long? = null

    constructor(
        id: String?, owner: String?, title: String?, content1Title: String?, content1Description: String?,
        content2Title: String?, content2Description: String?, createdAt: Long?, modifiedAt: Long?
    ) {
        this.id = id
        this.userId = owner
        this.title = title
        this.content1Title = content1Title
        this.content1Description = content1Description
        this.content2Title = content2Title
        this.content2Description = content2Description
        this.createdAt = createdAt
        this.modifiedAt = modifiedAt
    }
}