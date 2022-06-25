package com.meansoup.whatisthebetter.application.port.out.like.mysql

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@Import(MysqlLikeJpaRepositoryTest.TestConfig::class)
@SpringBootTest
private class MysqlLikeJpaRepositoryTest {

    @SpringBootApplication(scanBasePackages = ["com.meansoup.whatisthebetter"])
    class TestConfig


    @Autowired
    lateinit var sut: MysqlLikeDtoJpaRepository

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
}