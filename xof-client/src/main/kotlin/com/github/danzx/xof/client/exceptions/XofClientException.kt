package com.github.danzx.xof.client.exceptions

class XofClientException : Exception {
    constructor(message: String, ex: Exception): super(message, ex)
    constructor(message: String): super(message)
    constructor(ex: Exception): super(ex)

    companion object
}
