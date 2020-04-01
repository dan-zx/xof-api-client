package com.github.danzx.xof.client.api

interface BaseApi<T, CreateRequest> {
    fun getById(id: Long): T?
    fun create(request: CreateRequest): T
    fun delete(id: Long)
}
