package com.github.danzx.xof.client.impl.retrofit.test.factory

import com.github.danzx.xof.client.impl.retrofit.test.constants.APPLICATION_JSON
import com.github.danzx.xof.client.impl.retrofit.test.constants.TEXT_PLAIN

import okhttp3.ResponseBody

import retrofit2.Response.error

object ErrorObjectMother {

    fun <T> createTextPlainInternalServerError() =
        error<T>(500, ResponseBody.create(TEXT_PLAIN, "Internal Server Error"))

    fun <T> createTextPlainNotFoundError() =
        error<T>(404, ResponseBody.create(TEXT_PLAIN, "Not Found"))

    fun <T> createJsonNotFoundError() =
        error<T>(404, ResponseBody.create(APPLICATION_JSON,
            """
             {
                "error": "Not Found",
                "message": "Not Found",
                "path": "/api/mock",
                "status": 404,
                "timestamp": "2020-03-28T11:55:18"
             }
             """.trimIndent()))

    fun <T> createJsonInternalServerError() =
        error<T>(500, ResponseBody.create(APPLICATION_JSON,
            """
             {
                "error": "Internal Server Error",
                "message": "Internal Server Error",
                "path": "/api/mock",
                "status": 404,
                "timestamp": "2020-03-28T11:55:18"
             }
             """.trimIndent()))
}
