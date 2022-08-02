package com.meansoup.whatisthebetter.domain.post

import com.meansoup.whatisthebetter.domain.like.Likeable

data class Content(val title: String, val description: String): Likeable