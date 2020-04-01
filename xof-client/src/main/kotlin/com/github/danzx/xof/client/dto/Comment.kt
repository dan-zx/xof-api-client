package com.github.danzx.xof.client.dto

import java.time.LocalDateTime

data class Comment(
    var id: Long,
    var content: String,
    var created: LocalDateTime,
    var updated: LocalDateTime,
    var user: SimpleUser,
    var postId: Long,
    var parentId: Long?,
    var votes: Long) { companion object }
