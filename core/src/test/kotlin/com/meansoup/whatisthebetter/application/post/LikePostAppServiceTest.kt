package com.meansoup.whatisthebetter.application.post

import com.meansoup.whatisthebetter.domain.like.LikeService
import com.meansoup.whatisthebetter.domain.post.PostMother
import com.meansoup.whatisthebetter.domain.post.PostService
import com.meansoup.whatisthebetter.domain.user.UserMother
import com.meansoup.whatisthebetter.domain.user.UserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class LikePostAppServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Mock
    lateinit var postService: PostService

    @Mock
    lateinit var likeService: LikeService

    @InjectMocks
    lateinit var sut: LikePostAppService

    @Test
    fun `uid로 user를 찾아오고, postId로 post를 찾아와서 like를 호출한다`() {
        // given
        val user = UserMother.generate()
        val post = PostMother.generate()

        val uid = user.id
        val postId = post.id

        doReturn(user).`when`(userRepository).findBy(safeEq(uid))
        doReturn(post).`when`(postService).getPost(safeEq(postId))

        // when
        sut.execute(uid.toString(), postId.toString())

        // then
        verify(likeService, times(1)).like(safeEq(user), safeEq(post))
    }

    fun <T : Any> safeEq(value: T): T = Mockito.eq(value) ?: value
}