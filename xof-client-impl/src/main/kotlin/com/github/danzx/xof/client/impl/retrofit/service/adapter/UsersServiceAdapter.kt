package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.api.UsersApi
import com.github.danzx.xof.client.dto.Vote.Direction
import com.github.danzx.xof.client.dto.request.CreateUserRequest
import com.github.danzx.xof.client.dto.request.Pagination
import com.github.danzx.xof.client.dto.request.ReplaceUserRequest
import com.github.danzx.xof.client.dto.request.VoteRequest
import com.github.danzx.xof.client.impl.retrofit.ext.call
import com.github.danzx.xof.client.impl.retrofit.ext.get
import com.github.danzx.xof.client.impl.retrofit.ext.getOrNullOnNotFound
import com.github.danzx.xof.client.impl.retrofit.service.UsersService

class UsersServiceAdapter(private val usersService: UsersService) : UsersApi {

    override fun getById(id: Long) = usersService.getById(id).getOrNullOnNotFound()

    override fun getByUsername(username: String) = usersService.getByUsername(username).getOrNullOnNotFound()

    override fun create(request: CreateUserRequest) = usersService.create(request).get()

    override fun replace(id: Long, request: ReplaceUserRequest) = usersService.replace(id, request).get()

    override fun delete(id: Long) = usersService.delete(id).call()

    override fun getComments(id: Long, pagination: Pagination?) = usersService.getComments(id, pagination?.page, pagination?.size).get()

    override fun getPosts(id: Long, pagination: Pagination?) = usersService.getPosts(id, pagination?.page, pagination?.size).get()

    override fun voteOnComment(userId: Long, commentId: Long, vote: Direction) = usersService.voteOnComment(userId, commentId, VoteRequest(vote)).call()

    override fun voteOnPost(userId: Long, postId: Long, vote: Direction) = usersService.voteOnPost(userId, postId, VoteRequest(vote)).call()
}
