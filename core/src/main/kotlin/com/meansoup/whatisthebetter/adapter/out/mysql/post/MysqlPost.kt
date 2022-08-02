package com.meansoup.whatisthebetter.adapter.out.mysql.post

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "post")
class MysqlPost {

    @Id
    var id: String? = null

    @Column(name = "user_id")
    var userId: String? = null

    @Column
    var title: String? = null

    @Column(name = "content1_title")
    var content1Title: String? = null
    @Column(name = "content1_description")
    var content1Description: String? = null

    @Column(name = "content2_title")
    var content2Title: String? = null
    @Column(name = "content2_description")
    var content2Description: String? = null

    @Column
    var createdAt: Long? = null

    @Column
    var modifiedAt: Long? = null

    constructor() {}

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