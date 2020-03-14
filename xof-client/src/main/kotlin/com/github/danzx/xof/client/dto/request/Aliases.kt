package com.github.danzx.xof.client.dto.request

import com.github.danzx.xof.client.dto.Vote

typealias ReplaceUserRequest = CreateUserRequest
typealias ContentUpdateRequest = SingleValueRequest<String>
typealias TitleUpdateRequest = SingleValueRequest<String>
typealias VoteRequest = SingleValueRequest<Vote.Direction>
