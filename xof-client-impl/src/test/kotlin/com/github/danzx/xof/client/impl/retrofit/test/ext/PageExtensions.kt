package com.github.danzx.xof.client.impl.retrofit.test.ext

import com.github.danzx.xof.client.dto.response.Page
import com.github.danzx.xof.client.dto.response.Page.Links
import com.github.danzx.xof.client.dto.response.Page.Metadata

infix fun <T> Page.Companion.of(obj: T) =
    Page(
        data = setOf(obj),
        links = Links(
            previous = null,
            self = "http://localhost:8080/api/mocks?page=1&size1",
            next = null
        ),
        metadata = Metadata(
            total = 1,
            count = 1,
            totalPages = 1,
            number = 1
        )
    )