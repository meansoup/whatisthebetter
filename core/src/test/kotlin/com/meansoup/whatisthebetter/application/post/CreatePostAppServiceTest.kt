package com.meansoup.whatisthebetter.application.post

import com.meansoup.whatisthebetter.domain.post.Post
import com.meansoup.whatisthebetter.domain.post.PostService
import com.meansoup.whatisthebetter.domain.user.UserMother
import com.meansoup.whatisthebetter.domain.user.UserRepository
import org.apache.commons.lang3.RandomStringUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.eq
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CreatePostAppServiceTest {

    @InjectMocks
    lateinit var sut: CreatePostAppService

    @Mock
    lateinit var userRepository: UserRepository

    @Mock
    lateinit var postService: PostService

    @Captor
    lateinit var postCaptor: ArgumentCaptor<Post>

    @Test
    fun `execute하면 user를 찾아와서 param의 정보로 만든 post를 create한다`() {
        // given
        val user = UserMother.generate()
        val userId = user.id
        doReturn(user).`when`(userRepository).findBy(safeEq(userId))

        val postTitle = RandomStringUtils.randomAlphanumeric(10)
        val content1Title = RandomStringUtils.randomAlphanumeric(10)
        val content1Description = RandomStringUtils.randomAlphanumeric(10)
        val content2Title = RandomStringUtils.randomAlphanumeric(10)
        val content2Description = RandomStringUtils.randomAlphanumeric(10)

        // when
        val gotPost = sut.execute(user.id.toString(), postTitle, content1Title, content1Description, content2Title, content2Description)

        // then
        verify(postService, times(1)).createPost(capture(postCaptor))

        val post = postCaptor.value
        assertThat(post.title.name).isEqualTo(postTitle)

        assertThat(gotPost.id).isEqualTo(post.id)
        assertThat(gotPost.userId).isEqualTo(post.userId)
        assertThat(gotPost.title).isEqualTo(post.title)
        assertThat(gotPost.content1).isEqualTo(post.content1)
        assertThat(gotPost.content2).isEqualTo(post.content2)
        assertThat(gotPost.createdAt).isEqualTo(post.createdAt)
        assertThat(gotPost.modifiedAt).isEqualTo(post.modifiedAt)
    }

    fun <T> safeAny(type: Class<T>): T = any<T>(type)
    fun <T : Any> safeEq(value: T): T = eq(value) ?: value
    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}