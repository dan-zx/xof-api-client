package com.github.danzx.xof.client.impl.retrofit

import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level.BODY
import com.github.danzx.xof.client.configuration.dsl.config

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class XofClientNetworkTest : StringSpec({

    "test network connectivity".config(enabled = false) {
        val client = XofClientRetrofitFactory(
            config {
                baseUrl = "http://localhost:8081/api/v1/"
                logger { level = BODY }
            })
            .create()

        client.isServiceAvailable shouldBe true
    }
})
