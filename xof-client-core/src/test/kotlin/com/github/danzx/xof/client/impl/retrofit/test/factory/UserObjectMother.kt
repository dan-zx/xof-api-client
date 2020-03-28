package com.github.danzx.xof.client.impl.retrofit.test.factory

import com.github.danzx.xof.client.dto.SimpleUser
import com.github.danzx.xof.client.dto.User

import java.time.LocalDateTime

object UserObjectMother {

    fun createUser() = User(
        id = 1,
        name = "Test user",
        lastName = "Users Last Name",
        username = "Users Username",
        avatarImageUrl = "http://userimage.jpg",
        join = LocalDateTime.of(2019, 12, 6, 12, 0, 0)
    )

    fun createSimpleUser() = SimpleUser(
        id = 1,
        username = "Users Username"
    )
}
