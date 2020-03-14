package com.github.danzx.xof.client.impl.retrofit.ext

import com.github.danzx.xof.client.api.XofApiException
import com.github.danzx.xof.client.XofClientException

import retrofit2.Call

private fun <T> Call<T>.doGet(): T? {
    val response = execute()
    if (!response.isSuccessful) throw XofApiException(
        response.code(),
        response.errorBody()?.string()
    )
    return response.body()
}

fun <T> Call<T>.get() = doGet() ?: throw XofClientException("Expected body in response but got null!")

fun <T> Call<T>.getOrNullOnNotFound(): T? {
    try {
        return doGet()
    } catch (ex: XofApiException) {
        if (ex.statusCode == 404) return null
        throw ex
    }
}

fun Call<Unit>.call() { doGet() }
