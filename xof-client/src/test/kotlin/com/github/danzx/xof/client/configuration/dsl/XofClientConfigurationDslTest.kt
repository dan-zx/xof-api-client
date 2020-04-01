package com.github.danzx.xof.client.configuration.dsl

import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level.BASIC
import com.github.danzx.xof.client.ext.megabytes

import io.kotlintest.should
import io.kotlintest.shouldBe

import io.kotlintest.specs.StringSpec

import ru.yole.kxdate.minutes
import ru.yole.kxdate.nanoseconds
import ru.yole.kxdate.seconds

class XofClientConfigurationDslTest : StringSpec({

    "XofClientConfiguration DSL should build XofClientConfiguration object" {
        val config = config {
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

        config.baseUrl shouldBe "http://localhost:8080/api/v1/"

        config.connection should  {
            it.readTimeout shouldBe 30.seconds
            it.writeTimeout shouldBe 10.seconds
            it.connectTimeout shouldBe 1.minutes
            it.callTimeout shouldBe 100.nanoseconds
        }

        config.logger should {
            it.isEnabled shouldBe true
            it.level shouldBe BASIC
        }

        config.cache should {
            it.isEnabled shouldBe true
            it.sizeInBytes shouldBe 20.megabytes
        }
    }

})
