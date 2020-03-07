package com.github.danzx.xof.client.api

import com.github.danzx.xof.client.dto.Comment
import com.github.danzx.xof.client.dto.request.CreateCommentRequest
import com.github.danzx.xof.client.dto.request.Pagination
import com.github.danzx.xof.client.dto.response.Page

interface CommentsApi : BaseApi<Comment, CreateCommentRequest>{
    fun findReplays(id: Long, pagination: Pagination? = null): Page<Comment>
    fun replaceContent(id: Long, content: String): Comment
}