package com.meansoup.whatisthebetter.application.port.out.user.mysql

import com.meansoup.whatisthebetter.domain.exception.NullPropertyException
import com.meansoup.whatisthebetter.domain.user.Email
import com.meansoup.whatisthebetter.domain.user.User
import com.meansoup.whatisthebetter.domain.user.Username
import java.util.*

class MysqlUserFactory {

    companion object {
        fun create(user: User): MysqlUser {
            return MysqlUser(
                user.id.toString(),
                user.name.name,
                user.email.name,
                user.createdAt
            )
        }

        fun create(mysqlUser: MysqlUser): User {
            val name = mysqlUser.name ?: throw NullPropertyException("name is null in: " + mysqlUser.id)
            val email = mysqlUser.email ?: throw NullPropertyException("email is null in: " + mysqlUser.id)
            val createdAt = mysqlUser.createdAt ?: throw NullPropertyException("createdAt is null in: " + mysqlUser.id)

            return User(
                UUID.fromString(mysqlUser.id),
                Username(name),
                Email(email),
                createdAt
            )
        }
    }
}