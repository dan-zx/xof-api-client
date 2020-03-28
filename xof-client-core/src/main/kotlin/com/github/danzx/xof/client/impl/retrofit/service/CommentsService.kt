package com.github.danzx.xof.client.impl.retrofit.service

import com.github.danzx.xof.client.dto.Comment
import com.github.danzx.xof.client.dto.request.ContentUpdateRequest
import com.github.danzx.xof.client.dto.request.CreateCommentRequest
import com.github.danzx.xof.client.dto.response.Page

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentsService {

    @GET("$BASE_PATH/{id}")
    fun getById(@Path("id") id: Long): Call<Comment>

    @POST(BASE_PATH)
    fun create(@Body request: CreateCommentRequest): Call<Comment>

    @PUT("$BASE_PATH/{id}/content")
    fun replaceContent(@Path("id") id: Long, @Body request: ContentUpdateRequest): Call<Comment>

    @DELETE("$BASE_PATH/{id}")
    fun delete(@Path("id") id: Long): Call<Unit>

    @GET("$BASE_PATH/{id}/replies")
    fun getReplays(@Path("id") id: Long, @Query("page") page: Int? = null, @Query("size") size: Int? = null): Call<Page<Comment>>

    companion object {
        const val BASE_PATH = "comments"
    }
}