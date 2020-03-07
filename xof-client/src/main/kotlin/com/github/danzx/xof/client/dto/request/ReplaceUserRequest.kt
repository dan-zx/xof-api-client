package com.github.danzx.xof.client.dto.request

data class ReplaceUserRequest(
    var id: Long,
    var name: String,
    var lastName: String,
    var username: String,
    var avatarImageUrl: String)
