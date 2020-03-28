package com.github.danzx.xof.client.configuration.dsl

import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level.NONE

data class LoggerConfigImpl(
    override val isEnabled: Boolean,
    override val level: Level) : Logger

class LoggerConfigBuilder {
    private var level = NONE

    val Level.logs: Unit
        get() { level = this }

    fun build(): Logger = LoggerConfigImpl(true, level)
}
