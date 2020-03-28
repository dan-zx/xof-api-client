package com.github.danzx.xof.client.configuration.dsl

import com.github.danzx.xof.client.configuration.XofClientConfiguration.Cache

data class CacheConfigImpl(
    override val isEnabled: Boolean,
    override val cacheMaxSizeInBytes: Long) : Cache

class CacheConfigBuilder {
    companion object {
        const val BYTES_PER_KB = 1_024L
        const val DEFAULT_SIZE = 10L * BYTES_PER_KB * BYTES_PER_KB
    }

    private var size = DEFAULT_SIZE

    val Int.bytes: Unit
        get() { size = this.toLong() }

    val Int.kilobytes: Unit
        get() { size = this * BYTES_PER_KB }

    val Int.megabytes: Unit
        get() { size = this * BYTES_PER_KB * BYTES_PER_KB }

    fun build(): Cache = CacheConfigImpl(true, size)
}
