package com.github.danzx.xof.client.impl.retrofit.test.ext

import com.github.danzx.xof.client.dto.response.SuccessResponse

fun Boolean.toSuccessResponse() = SuccessResponse(this)
