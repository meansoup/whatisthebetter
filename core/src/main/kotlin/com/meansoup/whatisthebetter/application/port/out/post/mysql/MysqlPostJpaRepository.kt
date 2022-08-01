package com.meansoup.whatisthebetter.application.port.out.post.mysql

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MysqlPostJpaRepository : JpaRepository<MysqlPost, String>