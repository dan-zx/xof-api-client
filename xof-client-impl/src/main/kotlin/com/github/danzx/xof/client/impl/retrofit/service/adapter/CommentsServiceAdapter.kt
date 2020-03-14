package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.api.CommentsApi
import com.github.danzx.xof.client.dto.request.ContentUpdateRequest
import com.github.danzx.xof.client.dto.request.CreateCommentRequest
import com.github.danzx.xof.client.dto.request.Pagination
import com.github.danzx.xof.client.impl.retrofit.ext.call
import com.github.danzx.xof.client.impl.retrofit.ext.get
import com.github.danzx.xof.client.impl.retrofit.ext.getOrNullOnNotFound
import com.github.danzx.xof.client.impl.retrofit.service.CommentsService

class CommentsServiceAdapter(private val commentsService: CommentsService) : CommentsApi {
    override fun getById(id: Long) = commentsService.getById(id).getOrNullOnNotFound()
    override fun create(request: CreateCommentRequest) = commentsService.create(request).get()
    override fun delete(id: Long) = commentsService.delete(id).call()
    override fun replaceContent(id: Long, content: String) = commentsService.replaceContent(id, ContentUpdateRequest(content)).get()
    override fun getReplays(id: Long, pagination: Pagination?) = commentsService.getReplays(id, pagination?.page, pagination?.size).get()
}
