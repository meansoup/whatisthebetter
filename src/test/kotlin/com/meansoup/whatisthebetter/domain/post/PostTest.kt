package com.meansoup.whatisthebetter.domain.post

import org.apache.commons.lang3.RandomStringUtils
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
import org.junit.jupiter.api.Test

class PostTest {

    @Test
    fun `생성 시에 현재시각의 createdAt, modifiedAt이 설정된다`() {
        // given
        val id = RandomStringUtils.randomAlphanumeric(10)
        val title = TitleMother.generate()
        val target1 = TargetMother.generate()
        val target2 = TargetMother.generate()

        // when
        val post = Post(id, title, target1, target2)

        // then
        assertThat(post.id).isEqualTo(id)
        assertThat(post.title).isEqualTo(title)
        assertThat(post.target1).isEqualTo(target1)
        assertThat(post.target2).isEqualTo(target2)
        assertThat(post.createdAt).isCloseTo(System.currentTimeMillis(), Offset.offset(100))
        assertThat(post.createdAt).isEqualTo(post.modifiedAt)
    }

}

