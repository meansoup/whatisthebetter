package com.meansoup.whatisthebetter.application.post

import com.meansoup.whatisthebetter.application.port.`in`.GetPostUsecase
import com.meansoup.whatisthebetter.domain.like.LikeService
import com.meansoup.whatisthebetter.domain.post.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

class GetPostDto(
    val id: String,
    var ownerUsername: String,
    var title: String,
    var content1Title: String,
    var content1Description: String,
    var content2Title: String,
    var content2Description: String,
    var createdAt: Long,
    var modifiedAt: Long,
    var likeCnt: Long
)

@Service
class GetPostAppService @Autowired constructor(
    private val postService: PostService,
    private val likeService: LikeService
): GetPostUsecase {

    override fun execute(postId: String): GetPostDto {

        var id = UUID.fromString(postId)
        val post = postService.getPost(id)

        val likeCnt = likeService.likeCntOf(post)

        return GetPostDto(
            post.id.toString(),
            post.owner.name.name,
            post.title.name,
            post.content1.title,
            post.content1.description,
            post.content2.title,
            post.content2.description,
            post.createdAt,
            post.modifiedAt,
            likeCnt
        )
    }
}