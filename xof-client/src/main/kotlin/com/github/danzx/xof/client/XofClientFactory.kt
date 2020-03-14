package com.github.danzx.xof.client

abstract class XofClientFactory(protected val configuration: XofClientConfiguration) {
    abstract fun create() : XofClient
}
