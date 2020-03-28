package com.github.danzx.xof.client.impl.retrofit.service

import com.github.danzx.xof.client.dto.response.SuccessResponse

import retrofit2.Call
import retrofit2.http.GET

interface HealthService {

    @GET("health")
    fun check(): Call<SuccessResponse>
}
