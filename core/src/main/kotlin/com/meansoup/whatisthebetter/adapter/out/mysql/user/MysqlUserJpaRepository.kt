package com.meansoup.whatisthebetter.adapter.out.mysql.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MysqlUserJpaRepository : JpaRepository<MysqlUser, String>