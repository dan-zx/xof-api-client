package com.github.danzx.xof.client.impl.retrofit.ext

import com.github.danzx.xof.client.dto.Vote
import com.github.danzx.xof.client.dto.request.VoteRequest

fun Vote.Direction.toRequest() = VoteRequest(this)
