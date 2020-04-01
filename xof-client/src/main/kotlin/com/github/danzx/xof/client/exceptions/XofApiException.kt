package com.github.danzx.xof.client.exceptions

class XofApiException(val statusCode: Int, plainTextErrorMessage: String?) : Exception(plainTextErrorMessage) {
    companion object
}
