package com.github.danzx.xof.client.dto.request

import com.github.danzx.xof.client.dto.SingleValueHolder
import com.github.danzx.xof.client.dto.Vote.Direction

typealias ReplaceUserRequest = CreateUserRequest
typealias ContentUpdateRequest = SingleValueHolder<String>
typealias TitleUpdateRequest = SingleValueHolder<String>
typealias VoteRequest = SingleValueHolder<Direction>
