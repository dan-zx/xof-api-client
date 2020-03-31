package com.github.danzx.xof.client.impl.retrofit

import com.github.danzx.xof.client.XofClient
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level.BASIC
import com.github.danzx.xof.client.ext.megabytes
import io.kotlintest.shouldBe

import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec

import ru.yole.kxdate.minutes
import ru.yole.kxdate.nanoseconds
import ru.yole.kxdate.seconds

class XofClientSpiCreationTest : StringSpec({

    "should XofClient.newInstance() create a new XofClient with the default configuration" {
        val client = XofClient.newInstance()
        client shouldNotBe null
    }

    "should XofClient.overriding() create a new XofClient with the custom configuration" {
        val client = XofClient.overriding {
            connection {
                readTimeout = 30.seconds
                writeTimeout = 10.seconds
                connectTimeout = 1.minutes
                callTimeout = 100.nanoseconds
            }
            baseUrl = "http://localhost:8080/api/v1/"
            logger { level = BASIC }
            cache { size = 20.megabytes }
        }

        client shouldNotBe null
    }
})
