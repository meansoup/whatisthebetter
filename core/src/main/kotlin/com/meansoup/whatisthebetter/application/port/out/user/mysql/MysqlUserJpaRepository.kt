package com.meansoup.whatisthebetter.application.port.out.user.mysql

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MysqlUserJpaRepository : JpaRepository<MysqlUser, String>