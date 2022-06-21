package com.meansoup.whatisthebetter.domain.user

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var sut: UserService

    @Nested
    inner class `createUser` {

        @Test
        fun `createUser는 user를 repository에 저장한다`() {
            // given
            val user = UserMother.generate()

            // when
            sut.createUser(user)

            // then
            verify(userRepository, times(1)).save(safeEq(user))
        }
    }

    fun <T : Any> safeEq(value: T): T = Mockito.eq(value) ?: value
}