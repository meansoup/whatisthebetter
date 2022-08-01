package com.meansoup.whatisthebetter.application.post

import com.meansoup.whatisthebetter.domain.like.LikeService
import com.meansoup.whatisthebetter.domain.post.PostMother
import com.meansoup.whatisthebetter.domain.post.PostService
import org.apache.commons.lang3.RandomUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.eq
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class GetPostAppServiceTest {

    @InjectMocks
    lateinit var getPostAppService: GetPostAppService

    @Mock
    lateinit var postService: PostService

    @Mock
    lateinit var likeService: LikeService

    @Test
    fun `post를 가져오고 like count도 가져와서 보여준다`() {
        // given
        val post = PostMother.generate()
        val postId = post.id

        val likeCnt = RandomUtils.nextLong(1000L, 10000L)

        doReturn(post).`when`(postService).getPost(safeEq(postId))
        doReturn(likeCnt).`when`(likeService).likeCntOf(safeEq(post))

        // when
        var getPostDto = getPostAppService.execute(postId.toString())

        // then
        assertThat(getPostDto.id).isEqualTo(postId.toString())
        assertThat(getPostDto.ownerUsername).isEqualTo(post.userId.toString())
        assertThat(getPostDto.title).isEqualTo(post.title.name)
        assertThat(getPostDto.content1Title).isEqualTo(post.content1.title)
        assertThat(getPostDto.content1Description).isEqualTo(post.content1.description)
        assertThat(getPostDto.content2Title).isEqualTo(post.content2.title)
        assertThat(getPostDto.content2Description).isEqualTo(post.content2.description)
        assertThat(getPostDto.createdAt).isEqualTo(post.createdAt)
        assertThat(getPostDto.modifiedAt).isEqualTo(post.modifiedAt)
        assertThat(getPostDto.likeCnt).isEqualTo(likeCnt)
    }

    fun <T : Any> safeEq(value: T): T = eq(value) ?: value

}