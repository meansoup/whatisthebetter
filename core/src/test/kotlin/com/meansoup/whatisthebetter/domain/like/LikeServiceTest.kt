package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.ContentMother
import com.meansoup.whatisthebetter.domain.user.UserMother
import org.apache.commons.lang3.RandomUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
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

    @Nested
    inner class likeCntOf {

        @Test
        fun `likeCntOf returns like counts from likeRepository`() {
            // given
            val content = ContentMother.generate()
            val cnt = RandomUtils.nextLong(1000L, 10000L)
            doReturn(cnt).`when`(likeRepository).findAllCntOf(content)

            // when
            val foundCnt = sut.likeCntOf(content)

            // then
            assertThat(foundCnt).isEqualTo(cnt)
        }

    }

    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}