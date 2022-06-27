package com.meansoup.whatisthebetter.application.port.out.user.mysql

import com.meansoup.whatisthebetter.domain.user.User

class MysqlUserFactory {

    companion object {
        fun create(user: User): MysqlUser {
            return MysqlUser(
                user.id.toString(),
                user.name.name,
                user.email.toString(),
                user.createdAt
            )
        }
    }
}