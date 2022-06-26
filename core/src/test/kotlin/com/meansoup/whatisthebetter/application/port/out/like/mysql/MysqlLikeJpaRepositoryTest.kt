package com.meansoup.whatisthebetter.application.port.out.like.mysql

import org.apache.commons.lang3.RandomUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@Import(MysqlLikeJpaRepositoryTest.TestConfig::class)
@SpringBootTest
private class MysqlLikeJpaRepositoryTest {

    @SpringBootApplication(scanBasePackages = ["com.meansoup.whatisthebetter"])
    class TestConfig


    @Autowired
    lateinit var sut: MysqlLikeJpaRepository

    @Test
    fun `save & find`() {
        // given
        val mysqlLikeDto = MysqlLikeMother.generatePost()
        val id = MysqlLikeId(mysqlLikeDto.userId, mysqlLikeDto.likedId)

        // when
        sut.save(mysqlLikeDto)
        val found = sut.findById(id).get()

        // that
        assertThat(found.userId).isEqualTo(mysqlLikeDto.userId)
        assertThat(found.likedId).isEqualTo(mysqlLikeDto.likedId)
        assertThat(found.createdAt).isEqualTo(mysqlLikeDto.createdAt)
    }

    @Test
    fun `save & count`() {

        // given
        val likedId = UUID.randomUUID().toString()
        val likeCnt = RandomUtils.nextLong(3, 5)

        val mysqlLikes: ArrayList<MysqlLike> = ArrayList()

        for (i in 1..likeCnt) {
            val mysqlLikeDto = MysqlLikeMother.generatePost(likedId)
            mysqlLikes.add(mysqlLikeDto)
        }

        // when
        sut.saveAll(mysqlLikes)
        val foundCount = sut.countByLikedId(likedId)

        // that
        assertThat(foundCount).isEqualTo(likeCnt)
    }
}