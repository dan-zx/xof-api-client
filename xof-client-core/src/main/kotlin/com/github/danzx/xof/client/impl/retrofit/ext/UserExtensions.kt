package com.github.danzx.xof.client.impl.retrofit.ext

import com.github.danzx.xof.client.dto.User
import com.github.danzx.xof.client.dto.request.CreateUserRequest
import com.github.danzx.xof.client.dto.request.ReplaceUserRequest

fun User.toCreateRequest() = CreateUserRequest(name, lastName, username, avatarImageUrl)
fun User.toReplaceRequest() = ReplaceUserRequest(name, lastName, username, avatarImageUrl)
