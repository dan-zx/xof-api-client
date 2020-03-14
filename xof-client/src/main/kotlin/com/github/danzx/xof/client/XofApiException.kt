package com.github.danzx.xof.client

class XofApiException(val statusCode: Int, plainTextErrorMessage: String?) : Exception(plainTextErrorMessage)
