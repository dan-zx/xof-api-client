package com.github.danzx.xof.client

import com.github.danzx.xof.client.configuration.dsl.config
import com.github.danzx.xof.client.exceptions.XofClientException

import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class XofClientSpiTest : StringSpec({

    /* This methods are expected to fail here because the jar xof-client-core is not loaded yet. */

    "should newInstance() throw XofClientException when no XofClientFactory implementation is found by SPI" {
        shouldThrow<XofClientException> { XofClient.newInstance() }
    }

    "should newInstance(config) throw XofClientException when no XofClientFactory implementation is found by SPI" {
        shouldThrow<XofClientException> { XofClient.newInstance(config {  } ) }
    }
})