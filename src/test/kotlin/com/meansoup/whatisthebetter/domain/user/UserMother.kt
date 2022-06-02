package com.meansoup.whatisthebetter.domain.user

class UserMother {

    companion object {
        fun generate(): User {
            val username = UsernameMother.generate()
            val email = EmailMother.generate()

            return User(username, email)
        }
    }
}