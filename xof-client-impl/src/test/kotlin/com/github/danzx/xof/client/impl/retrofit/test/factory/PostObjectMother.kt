package com.github.danzx.xof.client.impl.retrofit.test.factory

import com.github.danzx.xof.client.dto.Post

import java.time.LocalDateTime

object PostObjectMother {

    fun createPost() = Post(
        id = 1,
        title = "Test Title",
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        created = LocalDateTime.of(2019, 12, 6, 12, 0, 0),
        updated = LocalDateTime.of(2019, 12, 6, 12, 0, 0),
        votes = 5,
        user = UserObjectMother.createSimpleUser()
    )
}