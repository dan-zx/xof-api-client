package com.github.danzx.xof.client.dto.response

import java.time.LocalDateTime

data class ErrorDetail(
    var error: String,
    var message: String,
    var fieldErrors: Map<String, String>,
    var path: String,
    var status: Int,
    var timestamp: LocalDateTime) { companion object }
