package com.meansoup.whatisthebetter.application.user

import com.meansoup.whatisthebetter.domain.user.EmailMother
import com.meansoup.whatisthebetter.domain.user.User
import com.meansoup.whatisthebetter.domain.user.UserService
import com.meansoup.whatisthebetter.domain.user.UsernameMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class JoinAppServiceTest {

    @Mock
    lateinit var userService: UserService

    @InjectMocks
    lateinit var sut: JoinAppService

    @Captor
    lateinit var userCaptor: ArgumentCaptor<User>

    @Test
    fun `create user with name & email and save at repository`() {
        // given
        val name = UsernameMother.generate().name
        val email = EmailMother.generate().name

        // when
        sut.execute(name, email)

        // then
        verify(userService, times(1)).createUser(capture(userCaptor))

        val user = userCaptor.value
        assertThat(user.name.name).isEqualTo(name)
        assertThat(user.email.name).isEqualTo(email)
    }

    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}