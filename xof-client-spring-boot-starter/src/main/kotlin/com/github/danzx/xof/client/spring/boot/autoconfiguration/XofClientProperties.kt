package com.github.danzx.xof.client.spring.boot.autoconfiguration

import com.github.danzx.xof.client.configuration.XofClientConfiguration
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level.NONE

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.util.unit.DataSize

import ru.yole.kxdate.nanoseconds
import ru.yole.kxdate.seconds

import java.time.Duration

@ConstructorBinding
@ConfigurationProperties("xof-client")
data class XofClientProperties(
    override val connection: ConnectionProperties = ConnectionProperties(),
    override val logger: LoggerProperties = LoggerProperties(),
    override val cache: CacheProperties = CacheProperties(),
    override val baseUrl: String = "https://xof.herokuapp.com/api/v1/") : XofClientConfiguration {

    @ConstructorBinding
    data class ConnectionProperties(
        override val readTimeout: Duration = 10.seconds,
        override val writeTimeout: Duration = 10.seconds,
        override val connectTimeout: Duration = 10.seconds,
        override val callTimeout: Duration = 0.nanoseconds) : XofClientConfiguration.Connection

    @ConstructorBinding
    data class LoggerProperties(
        private val enabled: Boolean = false,
        override val level: Level = NONE) : XofClientConfiguration.Logger {
        override val isEnabled = enabled
    }

    @ConstructorBinding
    data class CacheProperties(
        private val enabled: Boolean = false,
        private val size: DataSize = DataSize.ofMegabytes(10)) : XofClientConfiguration.Cache {
        override val isEnabled = enabled
        override val sizeInBytes = size.toBytes()
    }
}
