package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.dto.response.SuccessResponse
import com.github.danzx.xof.client.impl.retrofit.service.HealthService
import com.github.danzx.xof.client.impl.retrofit.test.ext.toSuccessResponse
import com.github.danzx.xof.client.impl.retrofit.test.factory.ErrorObjectMother

import io.kotlintest.shouldBe

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

import retrofit2.mock.Calls.response

import java.io.IOException

@ExtendWith(MockKExtension::class)
class HealthServiceAdapterTest {

    @MockK lateinit var healthService: HealthService
    @InjectMockKs lateinit var adapter: HealthServiceAdapter

    @Test
    fun `should check() return success value when service returns success response`() {
        val expected = true

        every { healthService.check() } returns response(expected.toSuccessResponse())

        adapter.isServiceAvailable shouldBe expected
    }

    @Test
    fun `should check() return false when service returns any error`() {
        val error = ErrorObjectMother.createJsonInternalServerError<SuccessResponse>()

        every { healthService.check() } returns response(error)

        adapter.isServiceAvailable shouldBe false
    }

    @Test
    fun `should check() return false when service throws any IOException`() {
        every { healthService.check() } throws IOException()

        adapter.isServiceAvailable shouldBe false
    }
}