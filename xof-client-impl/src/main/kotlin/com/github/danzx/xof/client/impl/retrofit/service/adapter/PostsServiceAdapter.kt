package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.api.PostsApi
import com.github.danzx.xof.client.dto.request.ContentUpdateRequest
import com.github.danzx.xof.client.dto.request.CreatePostRequest
import com.github.danzx.xof.client.dto.request.Pagination
import com.github.danzx.xof.client.dto.request.TitleUpdateRequest
import com.github.danzx.xof.client.impl.retrofit.ext.call
import com.github.danzx.xof.client.impl.retrofit.ext.get
import com.github.danzx.xof.client.impl.retrofit.ext.getOrNullOnNotFound
import com.github.danzx.xof.client.impl.retrofit.service.PostsService

class PostsServiceAdapter(private val postsService: PostsService) : PostsApi {
    override fun get(q: String?, pagination: Pagination?) = postsService.get(q, pagination?.page, pagination?.size).get()
    override fun getById(id: Long) = postsService.getById(id).getOrNullOnNotFound()
    override fun create(request: CreatePostRequest) = postsService.create(request).get()
    override fun replaceTitle(id: Long, title: String) = postsService.replaceTitle(id, TitleUpdateRequest(title)).get()
    override fun replaceContent(id: Long, content: String) = postsService.replaceContent(id, ContentUpdateRequest(content)).get()
    override fun delete(id: Long) = postsService.delete(id).call()
    override fun getComments(id: Long, pagination: Pagination?) = postsService.getComments(id, pagination?.page, pagination?.size).get()
}
