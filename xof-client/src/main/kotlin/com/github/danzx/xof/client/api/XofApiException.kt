package com.github.danzx.xof.client.api

class XofApiException(val statusCode: Int, plainTextErrorMessage: String?) : Exception(plainTextErrorMessage)
