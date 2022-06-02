package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.PostMother
import com.meansoup.whatisthebetter.domain.user.UserMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LikeTest {

    @Test
    fun `like consturctor set createdAt with currentTime`() {

        // given
        val user = UserMother.generate()
        val post = PostMother.generate()

        // when
        val like = Like(user, post)

        // then
        assertThat(like.createdAt)
    }
}