package com.meansoup.whatisthebetter.was.rest.post

import com.meansoup.whatisthebetter.application.port.`in`.user.JoinUseCase
import org.apache.commons.lang3.RandomStringUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class CreatePostControllerTest(
    @Autowired private val webClient: WebTestClient,
    @Autowired private val joinUseCase: JoinUseCase
) {

    @Test
    fun `normalCase`() {
        // given
        val name = RandomStringUtils.randomAlphanumeric(10)
        val email = RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphabetic(10) + ".com"

        val user = joinUseCase.execute(name, email)

        val request = CreatePostRequestMother.generate()

        // when & then
        val postResponse = webClient.post()
            .uri("v1/post")
            .header("uid", user.id.toString())
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(request))
            .exchange()
            .expectStatus().isCreated
            .returnResult(CreatePostResponse::class.java)
            .responseBody.blockFirst()

        assertThat(postResponse?.postId).isNotEmpty()
        assertThat(postResponse?.title).isEqualTo(request.title)
    }

}