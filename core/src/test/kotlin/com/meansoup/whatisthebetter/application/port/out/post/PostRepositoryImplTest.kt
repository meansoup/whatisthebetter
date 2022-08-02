package com.meansoup.whatisthebetter.application.port.out.post

import com.meansoup.whatisthebetter.adapter.out.mysql.post.MysqlPost
import com.meansoup.whatisthebetter.adapter.out.mysql.post.MysqlPostFactory
import com.meansoup.whatisthebetter.adapter.out.mysql.post.MysqlPostJpaRepository
import com.meansoup.whatisthebetter.domain.exception.ResourceNotExistException
import com.meansoup.whatisthebetter.domain.post.PostMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class PostRepositoryImplTest {

    @Mock
    lateinit var mysqlPostJpaRepository: MysqlPostJpaRepository

    @InjectMocks
    lateinit var sut: PostRepositoryImpl

    @Captor
    lateinit var captor: ArgumentCaptor<MysqlPost>

    @Nested
    inner class findBy {

        @Test
        fun normalCase() {
            // given
            val post = PostMother.generate()
            val mysqlPost = MysqlPostFactory.create(post)

            doReturn(Optional.of(mysqlPost)).`when`(mysqlPostJpaRepository).findById(safeEq(post.id.toString()))

            // when
            val found = sut.findBy(post.id)

            // then
            assertThat(found.id).isEqualTo(post.id)
            assertThat(found.userId).isEqualTo(post.userId)
            assertThat(found.title.name).isEqualTo(post.title.name)
            assertThat(found.content1.title).isEqualTo(post.content1.title)
            assertThat(found.content1.description).isEqualTo(post.content1.description)
            assertThat(found.content2.title).isEqualTo(post.content2.title)
            assertThat(found.content2.description).isEqualTo(post.content2.description)
            assertThat(found.createdAt).isEqualTo(post.createdAt)
            assertThat(found.modifiedAt).isEqualTo(post.modifiedAt)
        }

        @Test
        fun notExist() {
            val uuid = UUID.randomUUID()
            doReturn(Optional.ofNullable(null)).`when`(mysqlPostJpaRepository).findById(safeAny(String::class.java))

            // when & then
            assertThrows(ResourceNotExistException::class.java) {
                sut.findBy(uuid)
            }
        }
    }

    @Nested
    inner class save {

        @Test
        fun normalCase() {
            // given
            val post = PostMother.generate()

            // when
            sut.save(post)

            // then
            verify(mysqlPostJpaRepository, times(1)).save(capture(captor))
            val mysqlPostToSave = captor.value

            assertThat(mysqlPostToSave.id).isEqualTo(post.id.toString())
            assertThat(mysqlPostToSave.userId).isEqualTo(post.userId.toString())
            assertThat(mysqlPostToSave.title).isEqualTo(post.title.name)
            assertThat(mysqlPostToSave.content1Title).isEqualTo(post.content1.title)
            assertThat(mysqlPostToSave.content1Description).isEqualTo(post.content1.description)
            assertThat(mysqlPostToSave.content2Title).isEqualTo(post.content2.title)
            assertThat(mysqlPostToSave.content2Description).isEqualTo(post.content2.description)
            assertThat(mysqlPostToSave.createdAt).isEqualTo(post.createdAt)
            assertThat(mysqlPostToSave.modifiedAt).isEqualTo(post.modifiedAt)
        }
    }

    fun <T : Any> safeEq(value: T): T = Mockito.eq(value) ?: value
    fun <T> safeAny(type: Class<T>): T = any<T>(type)
    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}