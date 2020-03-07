package com.github.danzx.xof.client.dto.response

data class Page<T>(
    var data: Collection<T>,
    var links: Links,
    var metadata: Metadata) {

    data class Links(
        var previous: String? = null,
        var self: String,
        var next: String? = null
    )

    data class Metadata(
        var total: Long,
        var count: Int,
        var totalPages: Int,
        var number: Int
    )
}
