package com.meansoup.whatisthebetter.application.port.out.user

import com.meansoup.whatisthebetter.adapter.out.mysql.user.MysqlUser
import com.meansoup.whatisthebetter.adapter.out.mysql.user.MysqlUserFactory
import com.meansoup.whatisthebetter.adapter.out.mysql.user.MysqlUserJpaRepository
import com.meansoup.whatisthebetter.domain.exception.ResourceNotExistException
import com.meansoup.whatisthebetter.domain.user.UserMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class UserRepositoryImplTest {

    @Mock
    lateinit var mysqlUserJpaRepository: MysqlUserJpaRepository

    @InjectMocks
    lateinit var sut: UserRepositoryImpl

    @Captor
    lateinit var mysqlUserCaptor: ArgumentCaptor<MysqlUser>

    @Nested
    inner class findBy {

        @Test
        fun normalCase() {
            // given
            val user = UserMother.generate()
            val uuid = user.id;
            val mysqlUser = MysqlUserFactory.create(user)

            doReturn(Optional.of(mysqlUser)).`when`(mysqlUserJpaRepository).findById(safeEq(uuid.toString()))

            // when
            val found = sut.findBy(uuid)

            // then
            assertThat(found.id).isEqualTo(user.id)
            assertThat(found.email).isEqualTo(user.email)
            assertThat(found.name).isEqualTo(user.name)
            assertThat(found.createdAt).isEqualTo(user.createdAt)
        }

        @Test
        fun notExist() {
            // given
            val uuid = UUID.randomUUID()
            doReturn(Optional.ofNullable(null)).`when`(mysqlUserJpaRepository).findById(safeAny(String::class.java))

            // when & then
            assertThrows(ResourceNotExistException::class.java) {
                sut.findBy(uuid)
            }
        }
    }

    @Nested
    inner class save {

        @Test
        fun normalCase() {
            // given
            val user = UserMother.generate()

            // when
            sut.save(user)

            // then
            verify(mysqlUserJpaRepository, times(1)).save(capture(mysqlUserCaptor))
            val mysqlUserToSave = mysqlUserCaptor.value

            assertThat(mysqlUserToSave.id).isEqualTo(user.id.toString())
            assertThat(mysqlUserToSave.name).isEqualTo(user.name.name)
            assertThat(mysqlUserToSave.email).isEqualTo(user.email.name)
            assertThat(mysqlUserToSave.createdAt).isEqualTo(user.createdAt)
        }
    }

    fun <T : Any> safeEq(value: T): T = Mockito.eq(value) ?: value
    fun <T> safeAny(type: Class<T>): T = any<T>(type)
    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}