package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.dto.request.ContentUpdateRequest
import com.github.danzx.xof.client.dto.request.CreateCommentRequest
import com.github.danzx.xof.client.dto.response.Page
import com.github.danzx.xof.client.impl.retrofit.service.CommentsService
import com.github.danzx.xof.client.impl.retrofit.test.ext.of
import com.github.danzx.xof.client.impl.retrofit.test.factory.CommentObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.PaginationObjectMother

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

import retrofit2.mock.Calls.response

@ExtendWith(MockKExtension::class)
class CommentsServiceAdapterTest {

    @MockK lateinit var commentsService: CommentsService
    @InjectMockKs lateinit var adapter: CommentsServiceAdapter

    @Test
    fun `should getById() return response body when service returns success response`() {
        val expected = CommentObjectMother.createComment()

        every { commentsService.getById(expected.id) } returns response(expected)

        val actual = adapter.getById(expected.id)

        actual shouldNotBe null
        actual shouldBe expected
    }

    @Test
    fun `should create() return response body when service returns success response`() {
        val expected = CommentObjectMother.createComment()
        val request = CreateCommentRequest(expected.content, expected.user.id, expected.postId, expected.parentId)

        every { commentsService.create(request) } returns response(expected)

        val actual = adapter.create(request)

        actual shouldNotBe null
        actual shouldBe expected
    }

    @Test
    fun `should replaceContent() return response body when service returns success response`() {
        val expected = CommentObjectMother.createComment()

        every { commentsService.replaceContent(expected.id, ContentUpdateRequest(expected.content)) } returns response(expected)

        val actual = adapter.replaceContent(expected.id, expected.content)

        actual shouldNotBe null
        actual shouldBe expected
    }

    @Test
    fun `should delete() just runs when service returns success response`() {
        val requestId = 1L

        every { commentsService.delete(requestId) } returns response(Unit)

        adapter.delete(requestId)

        verify { commentsService.delete(requestId) }
    }

    @Test
    fun `should getReplays() return response body when service returns success response`() {
        val comment = CommentObjectMother.createCommentReplay()
        val expected = Page of comment
        val pagination = PaginationObjectMother.createPaginationForFirstPageWithOneResult()

        every { commentsService.getReplays(comment.parentId!!, pagination.page, pagination.size) } returns response(expected)

        val actual = adapter.getReplays(comment.parentId!!, pagination)

        actual shouldBe expected
    }
}