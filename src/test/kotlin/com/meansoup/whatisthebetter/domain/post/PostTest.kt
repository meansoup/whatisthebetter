package com.meansoup.whatisthebetter.domain.post

import com.meansoup.whatisthebetter.domain.user.UserMother
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
import org.junit.jupiter.api.Test

internal class PostTest {

    @Test
    fun `생성 시에 현재시각의 createdAt, modifiedAt이 설정되고 id가 부여된다`() {
        // given
        val owner = UserMother.generate()
        val title = TitleMother.generate()
        val target1 = ContentMother.generate()
        val target2 = ContentMother.generate()

        // when
        val post = Post(owner, title, target1, target2)

        // then
        assertThat(post.id).isNotNull()
        assertThat(post.owner).isEqualTo(owner)
        assertThat(post.title).isEqualTo(title)
        assertThat(post.content1).isEqualTo(target1)
        assertThat(post.content2).isEqualTo(target2)
        assertThat(post.createdAt).isCloseTo(System.currentTimeMillis(), Offset.offset(100))
        assertThat(post.createdAt).isEqualTo(post.modifiedAt)
    }
}


