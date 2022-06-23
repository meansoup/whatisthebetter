package com.meansoup.whatisthebetter.was.rest.post

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class GetPostControllerTest(
    @Autowired private val webClient: WebTestClient
) {

    @Test
    fun normalCase() {
        // given
        val postId = UUID.randomUUID().toString()

        // when & then
        val getPostResponse = webClient.get()
            .uri { builder ->
                builder
                    .path("v1/post")
                    .queryParam("postId", postId)
                    .build()
            }
            .exchange()
            .expectStatus().isOk
            .expectBody(GetPostResponse::class.java)
            .returnResult().responseBody

        assertThat(getPostResponse?.title).isNotEmpty()
    }
}