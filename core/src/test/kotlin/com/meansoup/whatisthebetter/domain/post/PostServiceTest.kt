package com.meansoup.whatisthebetter.domain.post

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.eq
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class PostServiceTest {

    @InjectMocks
    lateinit var sut: PostService

    @Mock
    lateinit var postRepository: PostRepository

    @Test
    fun `createPost save new post by user`() {
        // given
        val post = PostMother.generate()

        // when
        sut.createPost(post)

        // then
        verify(postRepository, times(1)).save(safeEq(post))
    }

    fun <T : Any> safeEq(value: T): T = eq(value) ?: value
}