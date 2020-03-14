package com.github.danzx.xof.client

import java.time.Duration

interface XofClientConfiguration {

    val connection: Connection
    val logger: Logger
    val cache: Cache

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
        val cacheMaxSizeInBytes: Long
    }
}

data class XofClientConfigurationSimple(
    override val connection: XofClientConfiguration.Connection = ConnectionSimple(),
    override val logger: XofClientConfiguration.Logger = LoggerSimple(),
    override val cache: XofClientConfiguration.Cache = CacheSimple()) : XofClientConfiguration {

    class ConnectionSimple(
        override val readTimeout: Duration = Duration.ofSeconds(10),
        override val writeTimeout: Duration = Duration.ofSeconds(10),
        override val connectTimeout: Duration = Duration.ofSeconds(10),
        override val callTimeout: Duration = Duration.ofNanos(0)) : XofClientConfiguration.Connection

    data class LoggerSimple(
        override val isEnabled: Boolean = false,
        override val level: XofClientConfiguration.Logger.Level = XofClientConfiguration.Logger.Level.NONE) : XofClientConfiguration.Logger

    data class CacheSimple(
        override val isEnabled: Boolean = false,
        override val cacheMaxSizeInBytes: Long = 10L * 1_024L * 1_024L) : XofClientConfiguration.Cache
}