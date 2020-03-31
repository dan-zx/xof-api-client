package com.github.danzx.xof.client.impl.retrofit

import com.github.danzx.xof.client.configuration.dsl.XofClientConfigurationBuilder

import io.kotlintest.should
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec

class XofClientRetrofitFactoryTest : StringSpec({

    "XofClientRetrofitFactory should build XofClient objects" {
        val client = XofClientRetrofitFactory().create(XofClientConfigurationBuilder().build())

        client should {
            it shouldNotBe null
            it.usersApi shouldNotBe null
            it.postsApi shouldNotBe null
            it.commentsApi shouldNotBe null
        }
    }
})
