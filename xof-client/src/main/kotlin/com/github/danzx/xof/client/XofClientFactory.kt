package com.github.danzx.xof.client

import com.github.danzx.xof.client.configuration.XofClientConfiguration

interface XofClientFactory {
    fun create(configuration: XofClientConfiguration) : XofClient
}
