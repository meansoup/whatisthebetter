package com.meansoup.whatisthebetter.domain.user

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun `User를 생성하면 createdAt이 현재 시각으로 설정되고 id가 추가된다`() {
        // given
        val username = UsernameMother.generate()
        val email = EmailMother.generate()

        // when
        val user = User(username, email)

        // then
        assertThat(user.createdAt).isCloseTo(System.currentTimeMillis(), Offset.offset(100))
        assertThat(user.id).isNotNull()
    }
}