package com.meansoup.whatisthebetter.application.port.out.like

import com.meansoup.whatisthebetter.application.exception.InvalidTypeException
import com.meansoup.whatisthebetter.application.port.out.like.mysql.MysqlLike
import com.meansoup.whatisthebetter.application.port.out.like.mysql.MysqlLikeDtoJpaRepository
import com.meansoup.whatisthebetter.domain.like.LikeMother
import com.meansoup.whatisthebetter.domain.like.Likeable
import com.meansoup.whatisthebetter.domain.post.Post
import com.meansoup.whatisthebetter.domain.post.PostMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class LikeRepositoryImplTest {

    @Mock
    lateinit var mysqlLikeDtoJpaRepository: MysqlLikeDtoJpaRepository

    @InjectMocks
    lateinit var sut: LikeRepositoryImpl

    @Captor
    lateinit var mysqlLikeCaptor: ArgumentCaptor<MysqlLike>

    @Test
    fun `save call mysqlLikeDtoJpaRepository save`() {
        // given
        val like = LikeMother.generatePost()

        // when
        sut.save(like)

        // then
        verify(mysqlLikeDtoJpaRepository, times(1)).save(mysqlLikeCaptor.capture())
        val mysqlLike = mysqlLikeCaptor.value

        assertThat(mysqlLike.userId).isEqualTo(like.user.id.toString())
        assertThat(mysqlLike.likedId).isEqualTo((like.thing as Post).id.toString())
    }

    @Nested
    inner class findAllCntOf {

        @Test
        fun `findAllCntOf call mysqlLikeDtoJpaRepository countByLikedId`() {
            // given
            val post = PostMother.generate()
            val postId = post.id.toString()

            // when
            sut.findAllCntOf(post)

            // then
            verify(mysqlLikeDtoJpaRepository, times(1)).countByLikedId(safeEq(postId))
        }

        @Test
        fun `findAllCntOf throw InvalidTypeException if unknown type`() {
            // given
            val post = UnKnownLikeableType()

            // when & then
            Assertions.assertThrows(InvalidTypeException::class.java) {
                sut.findAllCntOf(post)
            }
        }
    }

    class UnKnownLikeableType: Likeable

    fun <T : Any> safeEq(value: T): T = ArgumentMatchers.eq(value) ?: value
}