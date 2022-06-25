package com.meansoup.whatisthebetter.domain.like

import com.meansoup.whatisthebetter.domain.post.PostMother
import com.meansoup.whatisthebetter.domain.user.UserMother
import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class LikeMother {
    companion object {
        private val parameters = EasyRandomParameters().seed(System.currentTimeMillis())
        private val easyRandom: EasyRandom = EasyRandom(parameters)

        fun generatePost(): Like {
            val user = UserMother.generate()
            val post = PostMother.generate()

            return Like(user, post)
        }
    }
}