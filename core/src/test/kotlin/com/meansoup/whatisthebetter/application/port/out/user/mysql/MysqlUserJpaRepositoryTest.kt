package com.meansoup.whatisthebetter.application.port.out.user.mysql

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@Import(MysqlUserJpaRepositoryTest.TestConfig::class)
@SpringBootTest
class MysqlUserJpaRepositoryTest {

    @ComponentScan(basePackages = ["com.meansoup.whatisthebetter"])
    @SpringBootApplication(scanBasePackages = ["com.meansoup.whatisthebetter"])
    class TestConfig

    @Autowired
    lateinit var sut: MysqlUserJpaRepository

    @Test
    fun `save & find`() {
        // given
        val mysqlUser = MysqlUserMother.generate()
        val id = mysqlUser.id!!

        // when
        sut.save(mysqlUser)
        val found = sut.findById(id).get()

        // that
        assertThat(found.id).isEqualTo(mysqlUser.id)
        assertThat(found.name).isEqualTo(mysqlUser.name)
        assertThat(found.email).isEqualTo(mysqlUser.email)
        assertThat(found.createdAt).isEqualTo(mysqlUser.createdAt)
    }
}