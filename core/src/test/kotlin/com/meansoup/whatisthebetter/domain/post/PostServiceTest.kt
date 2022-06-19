package com.meansoup.whatisthebetter.domain.post

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.eq
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
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

    @Test
    fun `get Post from repository by id`() {
        // given
        val post = PostMother.generate()
        val id = post.id

        doReturn(post).`when`(postRepository).findBy(safeEq(id))

        // when
        val found = sut.getPost(id)

        // then
        assertThat(found).isEqualTo(post)
    }

    fun <T : Any> safeEq(value: T): T = eq(value) ?: value
}