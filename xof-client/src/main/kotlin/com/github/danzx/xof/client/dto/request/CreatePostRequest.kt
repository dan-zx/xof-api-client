package com.github.danzx.xof.client.dto.request

data class CreatePostRequest(
    var title: String,
    var content: String,
    var userId: Long)
