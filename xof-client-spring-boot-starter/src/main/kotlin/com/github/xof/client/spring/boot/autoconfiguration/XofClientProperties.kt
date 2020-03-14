package com.github.xof.client.spring.boot.autoconfiguration

import com.github.danzx.xof.client.XofClientConfiguration
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConstructorBinding
@ConfigurationProperties("xof-client")
data class XofClientProperties(
    override val connection: XofClientConfiguration.Connection = ConnectionProperties(),
    override val logger: XofClientConfiguration.Logger = LoggerProperties(),
    override val cache: XofClientConfiguration.Cache = CacheProperties()) : XofClientConfiguration {

    class ConnectionProperties(
        override val readTimeout: Duration = Duration.ofSeconds(10),
        override val writeTimeout: Duration = Duration.ofSeconds(10),
        override val connectTimeout: Duration = Duration.ofSeconds(10),
        override val callTimeout: Duration = Duration.ofNanos(0)) : XofClientConfiguration.Connection

    data class LoggerProperties(
        override val isEnabled: Boolean = false,
        override val level: XofClientConfiguration.Logger.Level = XofClientConfiguration.Logger.Level.NONE) : XofClientConfiguration.Logger

    data class CacheProperties(
        override val isEnabled: Boolean = false,
        override val cacheMaxSizeInBytes: Long = 10L * 1_024L * 1_024L) : XofClientConfiguration.Cache
}
