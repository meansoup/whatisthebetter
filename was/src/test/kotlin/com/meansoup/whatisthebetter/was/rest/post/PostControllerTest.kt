package com.meansoup.whatisthebetter.was.rest.post

import com.meansoup.whatisthebetter.was.utils.JsonUtils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class PostControllerTest(
    @Autowired private val webClient: WebTestClient
) {

    @Nested
    inner class createPost {

        @Test
        fun `normalCase`() {
            // given
            val uid = UUID.randomUUID().toString()

            val request = CreatePostRequestMother.generate()
            val jsonRequest = JsonUtils.toJson(request)

            // when & then
            webClient.post()
                .uri {
                        builder -> builder
                    .path("v1/post")
                    .queryParam("uid", uid)
                    .build()
                }
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(jsonRequest))
                .exchange()
                .expectStatus().isCreated
        }
    }

}