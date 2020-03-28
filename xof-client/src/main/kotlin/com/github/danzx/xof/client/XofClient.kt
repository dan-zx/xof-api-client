package com.github.danzx.xof.client

import com.github.danzx.xof.client.api.CommentsApi
import com.github.danzx.xof.client.api.HealthApi
import com.github.danzx.xof.client.api.PostsApi
import com.github.danzx.xof.client.api.UsersApi

data class XofClient(
    val usersApi: UsersApi,
    val postsApi: PostsApi,
    val commentsApi: CommentsApi,
    private val healthApi: HealthApi) {

    val isServiceAvailable
        get() = healthApi.isServiceAvailable

    companion object
}
