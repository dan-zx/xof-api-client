package com.github.danzx.xof.client.configuration.dsl

import com.github.danzx.xof.client.configuration.XofClientConfiguration.Connection

import ru.yole.kxdate.nanoseconds
import ru.yole.kxdate.seconds

import java.time.Duration


data class ConnectionConfigImpl(
    override val readTimeout: Duration,
    override val writeTimeout: Duration,
    override val connectTimeout: Duration,
    override val callTimeout: Duration) : Connection

class ConnectionConfigBuilder {
    var readTimeout = 10.seconds
    var writeTimeout = 10.seconds
    var connectTimeout = 10.seconds
    var callTimeout = 0.nanoseconds

    fun build(): Connection = ConnectionConfigImpl(readTimeout, writeTimeout, connectTimeout, callTimeout)
}
