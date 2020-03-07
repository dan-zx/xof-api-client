package com.github.danzx.xof.client.api

import com.github.danzx.xof.client.dto.Comment
import com.github.danzx.xof.client.dto.Post
import com.github.danzx.xof.client.dto.request.CreatePostRequest
import com.github.danzx.xof.client.dto.request.Pagination
import com.github.danzx.xof.client.dto.response.Page

interface PostsApi : BaseApi<Post, CreatePostRequest>{
    fun get(q: String? = null, pagination: Pagination? = null): Page<Post>
    fun findComments(id: Long, pagination: Pagination? = null): Page<Comment>
    fun replaceTitle(id: Long, title: String): Post
    fun replaceContent(id: Long, content: String): Post
}
