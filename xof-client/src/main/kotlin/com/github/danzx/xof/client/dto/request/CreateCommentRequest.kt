package com.github.danzx.xof.client.dto.request

data class CreateCommentRequest(
    var content: String,
    var userId: Long,
    var postId: Long,
    var parentId: Long? = null)
