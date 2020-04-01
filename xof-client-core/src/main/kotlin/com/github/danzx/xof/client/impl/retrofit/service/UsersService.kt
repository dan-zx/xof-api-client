package com.github.danzx.xof.client.impl.retrofit.service

import com.github.danzx.xof.client.dto.Comment
import com.github.danzx.xof.client.dto.Post
import com.github.danzx.xof.client.dto.User
import com.github.danzx.xof.client.dto.request.CreateUserRequest
import com.github.danzx.xof.client.dto.request.ReplaceUserRequest
import com.github.danzx.xof.client.dto.request.VoteRequest
import com.github.danzx.xof.client.dto.response.Page

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {

    @GET("$BASE_PATH/{id}")
    fun getById(@Path("id") id: Long): Call<User>

    @GET(BASE_PATH)
    fun getByUsername(@Query("username") username: String): Call<User>

    @POST(BASE_PATH)
    fun create(@Body request: CreateUserRequest): Call<User>

    @PUT("$BASE_PATH/{id}")
    fun replace(@Path("id") id: Long, @Body request: ReplaceUserRequest): Call<User>

    @DELETE("$BASE_PATH/{id}")
    fun delete(@Path("id") id: Long): Call<Unit>

    @GET("$BASE_PATH/{id}/comments")
    fun getComments(id: Long, @Query("page") page: Int? = null, @Query("size") size: Int? = null): Call<Page<Comment>>

    @GET("$BASE_PATH/{id}/posts")
    fun getPosts(id: Long, @Query("page") page: Int? = null, @Query("size") size: Int? = null): Call<Page<Post>>

    @PUT("$BASE_PATH/{userId}/comments/{commentId}/votes")
    fun voteOnComment(@Path("userId") userId: Long, @Path("commentId") commentId: Long, @Body request: VoteRequest): Call<Unit>

    @PUT("$BASE_PATH/{userId}/posts/{postId}/votes")
    fun voteOnPost(@Path("userId") userId: Long, @Path("postId") postId: Long, @Body request: VoteRequest): Call<Unit>

    companion object {
        const val BASE_PATH = "users"
    }
}