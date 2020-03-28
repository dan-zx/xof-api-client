package com.github.danzx.xof.client

import com.github.danzx.xof.client.configuration.XofClientConfiguration

abstract class XofClientFactory(protected val configuration: XofClientConfiguration) {
    abstract fun create() : XofClient
}
