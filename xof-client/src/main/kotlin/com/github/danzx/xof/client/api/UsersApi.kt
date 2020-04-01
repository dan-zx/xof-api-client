package com.github.danzx.xof.client.api

import com.github.danzx.xof.client.dto.Comment
import com.github.danzx.xof.client.dto.Post
import com.github.danzx.xof.client.dto.User
import com.github.danzx.xof.client.dto.Vote
import com.github.danzx.xof.client.dto.request.CreateUserRequest
import com.github.danzx.xof.client.dto.request.Pagination
import com.github.danzx.xof.client.dto.request.ReplaceUserRequest
import com.github.danzx.xof.client.dto.response.Page

interface UsersApi : BaseApi<User, CreateUserRequest> {
    fun getByUsername(username: String): User?
    fun replace(id: Long, request: ReplaceUserRequest): User
    fun getComments(id: Long, pagination: Pagination? = null): Page<Comment>
    fun getPosts(id: Long, pagination: Pagination? = null): Page<Post>
    fun voteOnComment(userId: Long, commentId: Long, vote: Vote.Direction)
    fun voteOnPost(userId: Long, postId: Long, vote: Vote.Direction)
}
