package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.ContentMother
import com.meansoup.whatisthebetter.domain.user.UserMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LikeTest {

    @Test
    fun `like consturctor set createdAt with currentTime`() {

        // given
        val user = UserMother.generate()
        val content = ContentMother.generate()

        // when
        val like = Like(user, content)

        // then
        assertThat(like.createdAt)
    }
}