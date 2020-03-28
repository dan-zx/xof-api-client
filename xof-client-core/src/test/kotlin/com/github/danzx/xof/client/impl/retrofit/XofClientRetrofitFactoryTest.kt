package com.github.danzx.xof.client.impl.retrofit

import com.github.danzx.xof.client.configuration.dsl.config

import io.kotlintest.should
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec

class XofClientRetrofitFactoryTest : StringSpec({

    "XofClientRetrofitFactory should build XofClient objects" {
        val client = XofClientRetrofitFactory(config { baseUrl = "http://localhost:8080/" }).create()

        client should {
            it shouldNotBe null
            it.usersApi shouldNotBe null
            it.postsApi shouldNotBe null
            it.commentsApi shouldNotBe null
        }
    }
})
