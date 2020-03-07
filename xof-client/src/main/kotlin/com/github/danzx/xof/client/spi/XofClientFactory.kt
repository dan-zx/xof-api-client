package com.github.danzx.xof.client.spi

import com.github.danzx.xof.client.XofClient

import java.util.ServiceLoader

object XofClientFactory {

    val xofClient = InstanceHolder.xofClient

    private class InstanceHolder {
        companion object {
            val xofClient = createClient()
            private fun createClient(): XofClient {
                val loader = ServiceLoader.load(XofClientProvider::class.java)
                val provider = loader.findFirst().orElseThrow { XofClientFactoryException("No XofClientProvider implementation found!") }
                return provider.xofClient
            }
        }
    }
}

