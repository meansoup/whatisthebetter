package com.meansoup.whatisthebetter.adapter.out.mysql.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MysqlPostJpaRepository : JpaRepository<MysqlPost, String>