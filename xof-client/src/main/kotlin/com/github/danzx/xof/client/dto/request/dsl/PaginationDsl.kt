package com.github.danzx.xof.client.dto.request.dsl

import com.github.danzx.xof.client.dto.request.Pagination

object page

class PaginationBuilder {
    private var size: Int? = null
    private var number: Int? = null

    infix fun page.size(value: Int?) {
        size = value
    }

    infix fun page.number(value: Int?) {
        number = value
    }

    fun build() = Pagination(size = size, page = number)
}

fun paginationWith(actions: PaginationBuilder.() -> Unit) : Pagination {
    val builder = PaginationBuilder()
    builder.actions()
    return builder.build()
}
