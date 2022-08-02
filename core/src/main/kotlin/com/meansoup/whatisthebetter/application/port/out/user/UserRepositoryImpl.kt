package com.meansoup.whatisthebetter.application.port.out.user

import com.meansoup.whatisthebetter.adapter.out.mysql.user.MysqlUserFactory
import com.meansoup.whatisthebetter.adapter.out.mysql.user.MysqlUserJpaRepository
import com.meansoup.whatisthebetter.domain.exception.ResourceNotExistException
import com.meansoup.whatisthebetter.domain.user.User
import com.meansoup.whatisthebetter.domain.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepositoryImpl @Autowired constructor(
    private val mysqlUserJpaRepository: MysqlUserJpaRepository
): UserRepository {

    override fun findBy(uid: UUID): User {

        val found = mysqlUserJpaRepository.findByIdOrNull(uid.toString())

        found?: throw ResourceNotExistException("User not exist: $uid")

        return MysqlUserFactory.create(found)
    }

    override fun save(user: User) {
        val mysqlUser = MysqlUserFactory.create(user)
        mysqlUserJpaRepository.save(mysqlUser)
    }
}