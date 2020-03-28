package com.github.danzx.xof.client.impl.retrofit.test.factory

import com.github.danzx.xof.client.dto.Comment
import java.time.LocalDateTime

object CommentObjectMother {

    fun createComment() = Comment(
        id = 1,
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        created = LocalDateTime.of(2019, 12, 6, 12, 0, 0),
        updated = LocalDateTime.of(2019, 12, 6, 12, 0, 0),
        user = UserObjectMother.createSimpleUser(),
        postId = 1,
        parentId = null,
        votes = 0
    )

    fun createCommentReplay() = Comment(
        id = 2,
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        created = LocalDateTime.of(2020, 4, 6, 12, 0, 0),
        updated = LocalDateTime.of(2020, 4, 6, 12, 0, 0),
        user = UserObjectMother.createSimpleUser(),
        postId = 1,
        parentId = 1,
        votes = 0
    )
}