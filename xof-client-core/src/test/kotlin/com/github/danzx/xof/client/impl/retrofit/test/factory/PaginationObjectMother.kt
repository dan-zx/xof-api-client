package com.github.danzx.xof.client.impl.retrofit.test.factory

import com.github.danzx.xof.client.dto.request.dsl.page
import com.github.danzx.xof.client.dto.request.dsl.paginationWith

object PaginationObjectMother {

    fun createPaginationForFirstPageWithOneResult() =
        paginationWith {
            page number 1
            page size 1
        }
}
