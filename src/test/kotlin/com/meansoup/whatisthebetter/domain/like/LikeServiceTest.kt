package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.ContentMother
import com.meansoup.whatisthebetter.domain.user.UserMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
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
class LikeServiceTest {

    @InjectMocks
    lateinit var sut: LikeService

    @Mock
    lateinit var likeRepository: LikeRepository

    @Captor
    lateinit var likeCaptor: ArgumentCaptor<Like>

    @Nested
    inner class like {

        @Test
        fun `like save new like with user & content`() {
            // given
            val user = UserMother.generate()
            val content = ContentMother.generate()

            // when
            sut.like(user, content)

            // then
            verify(likeRepository, times(1)).save(capture(likeCaptor))

            val like = likeCaptor.value
            assertThat(like.user).isEqualTo(user)
            assertThat(like.thing).isEqualTo(content)
        }
    }

    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}