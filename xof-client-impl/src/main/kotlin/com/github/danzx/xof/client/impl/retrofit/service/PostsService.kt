package com.github.danzx.xof.client.impl.retrofit.service

import com.github.danzx.xof.client.dto.Comment
import com.github.danzx.xof.client.dto.Post
import com.github.danzx.xof.client.dto.request.ContentUpdateRequest
import com.github.danzx.xof.client.dto.request.CreatePostRequest
import com.github.danzx.xof.client.dto.request.TitleUpdateRequest
import com.github.danzx.xof.client.dto.response.Page

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PostsService {

    @GET(BASE_PATH)
    fun get(@Query("q") q: String? = null, @Query("page") page: Int? = null, @Query("size") size: Int? = null): Call<Page<Post>>

    @GET("$BASE_PATH/{id}")
    fun getById(@Path("id") id: Long): Call<Post>

    @POST(BASE_PATH)
    fun create(@Body request: CreatePostRequest): Call<Post>

    @PUT("$BASE_PATH/{id}/title")
    fun replaceTitle(@Path("id") id: Long, @Body request: TitleUpdateRequest): Call<Post>

    @PUT("$BASE_PATH/{id}/content")
    fun replaceContent(@Path("id") id: Long, @Body request: ContentUpdateRequest): Call<Post>

    @DELETE("$BASE_PATH/{id}")
    fun delete(@Path("id") id: Long): Call<Unit>

    @GET("$BASE_PATH/{id}/comments")
    fun getComments(@Path("id") id: Long, @Query("page") page: Int? = null, @Query("size") size: Int? = null): Call<Page<Comment>>

    companion object {
        const val BASE_PATH = "posts"
    }
}