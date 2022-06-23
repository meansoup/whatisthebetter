package com.meansoup.whatisthebetter.was.rest.post

import com.meansoup.whatisthebetter.was.utils.JsonUtils
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
internal class CreatePostControllerTest(
    @Autowired private val webClient: WebTestClient
) {

    @Test
    fun `normalCase`() {
        // given
        val uid = UUID.randomUUID().toString()

        val request = CreatePostRequestMother.generate()
        val jsonRequest = JsonUtils.toJson(request)

        // when & then
        webClient.post()
            .uri("v1/post")
            .header("uid", uid)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(jsonRequest))
            .exchange()
            .expectStatus().isCreated
    }

}