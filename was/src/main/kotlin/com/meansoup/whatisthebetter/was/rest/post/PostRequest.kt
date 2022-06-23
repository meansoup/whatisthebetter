package com.meansoup.whatisthebetter.was.rest.post

data class CreatePostRequest(val title: String, val content1: ContentRequest, val content2: ContentRequest)
data class ContentRequest(val title: String, val description: String)