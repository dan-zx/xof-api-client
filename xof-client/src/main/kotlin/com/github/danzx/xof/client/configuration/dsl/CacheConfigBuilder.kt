package com.github.danzx.xof.client.configuration.dsl

import com.github.danzx.xof.client.configuration.XofClientConfiguration.Cache
import com.github.danzx.xof.client.ext.BYTES_PER_KB
import com.github.danzx.xof.client.ext.`**`

data class CacheConfigImpl(
    override val isEnabled: Boolean,
    override val sizeInBytes: Long) : Cache

class CacheConfigBuilder {
    companion object {
        val DEFAULT_SIZE = 10L * BYTES_PER_KB `**` 2
    }

    var size = DEFAULT_SIZE

    fun build(): Cache = CacheConfigImpl(true, size)
}
