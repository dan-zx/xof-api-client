package com.github.danzx.xof.client.configuration.dsl

import com.github.danzx.xof.client.configuration.XofClientConfiguration
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Cache
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Connection
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger

data class XofClientConfigurationImpl(
    override val connection: Connection,
    override val logger: Logger,
    override val cache: Cache,
    override val baseUrl: String) : XofClientConfiguration

class XofClientConfigurationBuilder {
    private var connection: Connection = ConnectionConfigBuilder().build()
    private var logger: Logger = LoggerConfigBuilder().build()
    private var cache: Cache = CacheConfigBuilder().build()

    lateinit var baseUrl: String

    fun connection(setup: ConnectionConfigBuilder.() -> Unit) {
        val builder = ConnectionConfigBuilder()
        builder.setup()
        connection = builder.build()
    }

    fun logger(setup: LoggerConfigBuilder.() -> Unit) {
        val builder = LoggerConfigBuilder()
        builder.setup()
        logger = builder.build()
    }

    fun cache(setup: CacheConfigBuilder.() -> Unit) {
        val builder = CacheConfigBuilder()
        builder.setup()
        cache = builder.build()
    }

    fun build(): XofClientConfiguration = XofClientConfigurationImpl(connection, logger, cache, baseUrl)
}

fun config(setup: XofClientConfigurationBuilder.() -> Unit): XofClientConfiguration {
    val builder = XofClientConfigurationBuilder()
    builder.setup()
    return builder.build()
}
