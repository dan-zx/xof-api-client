package com.github.danzx.xof.client.spi

import com.github.danzx.xof.client.XofClient

interface XofClientProvider {
    val xofClient: XofClient
}
