package com.github.danzx.xof.client.dto

import java.time.LocalDateTime

data class Post(
    var id: Long,
    var title: String,
    var content: String,
    var created: LocalDateTime,
    var updated: LocalDateTime,
    var user: SimpleUser,
    var votes: Long)
