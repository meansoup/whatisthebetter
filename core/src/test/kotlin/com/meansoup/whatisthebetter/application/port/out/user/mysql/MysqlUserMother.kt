package com.meansoup.whatisthebetter.application.port.out.user.mysql

import com.meansoup.whatisthebetter.domain.user.UserMother

class MysqlUserMother {

    companion object {
        fun generate(): MysqlUser {
            val user = UserMother.generate()
            return MysqlUserFactory.create(user)
        }
    }
}