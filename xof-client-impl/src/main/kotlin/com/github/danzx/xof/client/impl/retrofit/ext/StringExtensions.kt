package com.github.danzx.xof.client.impl.retrofit.ext

import com.github.danzx.xof.client.dto.request.ContentUpdateRequest
import com.github.danzx.xof.client.dto.request.TitleUpdateRequest

fun String.toTitleUpdateRequest() = TitleUpdateRequest(this)
fun String.toContentUpdateRequest() = ContentUpdateRequest(this)
