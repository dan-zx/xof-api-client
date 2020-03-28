package com.github.danzx.xof.client.impl.retrofit.ext

import com.github.danzx.xof.client.exceptions.XofApiException
import com.github.danzx.xof.client.exceptions.XofClientException
import com.github.danzx.xof.client.impl.retrofit.test.factory.ErrorObjectMother

import io.kotlintest.matchers.types.shouldBeSameInstanceAs
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

import retrofit2.mock.Calls.response

class CallExtensionsTest : StringSpec({

    "should get() return non null result when response is successful" {
        val expected = Any()
        val actual = response(expected).get()

        actual shouldBeSameInstanceAs expected
    }

    "should getOrNullOnNotFound() return non null result when response is successful" {
        val expected = Any()
        val actual = response(expected).getOrNullOnNotFound()

        actual shouldBeSameInstanceAs expected
    }

    "should getOrNullOnNotFound() return null result when response is 404" {
        val error = ErrorObjectMother.createTextPlainNotFoundError<Any>()
        val actual = response(error).getOrNullOnNotFound()

        actual shouldBe null
    }

    "should get() throw XofClientException when response is null" {
        shouldThrow<XofClientException> { response(null as Any?).get() }
    }

    "should get() throw XofApiException when response is not successful" {
        val error = ErrorObjectMother.createTextPlainInternalServerError<Any>()
        shouldThrow<XofApiException> { response(error).get() }
    }

    "should getOrNullOnNotFound() throw XofApiException when response is not successful" {
        val error = ErrorObjectMother.createTextPlainInternalServerError<Any>()
        shouldThrow<XofApiException> { response(error).getOrNullOnNotFound() }
    }
})
