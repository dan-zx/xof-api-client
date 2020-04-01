package com.github.danzx.xof.client.dto.request

data class CreateUserRequest(
    var name: String,
    var lastName: String,
    var username: String,
    var avatarImageUrl: String) { companion object }
