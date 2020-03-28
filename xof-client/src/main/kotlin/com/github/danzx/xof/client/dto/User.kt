package com.github.danzx.xof.client.dto

import java.time.LocalDateTime

data class User(
    var id: Long,
    var name: String,
    var lastName: String,
    var username: String,
    var avatarImageUrl: String,
    var join: LocalDateTime) { companion object }

data class SimpleUser(
    var id: Long,
    var username: String) { companion object }
