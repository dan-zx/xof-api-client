package com.github.danzx.xof.client.configuration

import java.time.Duration

interface XofClientConfiguration {

    val connection: Connection
    val logger: Logger
    val cache: Cache
    val baseUrl: String

    interface Connection {
        val readTimeout: Duration
        val writeTimeout: Duration
        val connectTimeout: Duration
        val callTimeout: Duration
    }

    interface Logger {
        enum class Level { NONE, BASIC, HEADERS, BODY }

        val isEnabled: Boolean
        val level: Level
    }

    interface Cache {
        val isEnabled: Boolean
        val sizeInBytes: Long
    }
}
