package com.meansoup.whatisthebetter.was.utils

import org.apache.commons.lang3.RandomStringUtils
import org.apache.commons.lang3.RandomUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonUtilsTest {

    data class JsonUtilsTestParent(val name: String, val child1: JsonUtilsTestChild, val child2: JsonUtilsTestChild)
    data class JsonUtilsTestChild(val name: String, val age: Int)

    @Test
    fun `Any to string & string to Any`() {
        // given
        val testObject = JsonUtilsTestParent(
            RandomStringUtils.randomAlphanumeric(10),
            JsonUtilsTestChild(RandomStringUtils.randomAlphanumeric(10), RandomUtils.nextInt(10, 100)),
            JsonUtilsTestChild(RandomStringUtils.randomAlphanumeric(10), RandomUtils.nextInt(10, 100))
        )

        // when
        val json = JsonUtils.toJson(testObject)
        println(json)

        val result = JsonUtils.toType<JsonUtilsTestParent>(json)

        // then
        assertThat(result).isEqualTo(testObject)
    }
}


