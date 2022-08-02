package com.meansoup.whatisthebetter.was.rest.user

import com.meansoup.whatisthebetter.was.utils.JsonUtils
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
internal class JoinUserControllerTest(
    @Autowired private val webClient: WebTestClient
) {

    @Test
    fun `normalCase`() {
        // given
        val request = JoinRequestMother.generate()
        val jsonRequest = JsonUtils.toJson(request)

        // when & then
        val joinResponse = webClient.post()
            .uri("v1/user")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(jsonRequest))
            .exchange()
            .expectStatus().isCreated
            .returnResult(JoinResponse::class.java)
            .responseBody.blockFirst()

        assertThat(joinResponse?.userId).isNotNull()
        assertThat(joinResponse?.name).isEqualTo(request.name)
        assertThat(joinResponse?.email).isEqualTo(request.email)
    }
}