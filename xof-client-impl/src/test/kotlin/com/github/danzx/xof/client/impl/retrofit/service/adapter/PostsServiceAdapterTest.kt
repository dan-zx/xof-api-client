package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.dto.Post
import com.github.danzx.xof.client.dto.request.ContentUpdateRequest
import com.github.danzx.xof.client.dto.request.CreatePostRequest
import com.github.danzx.xof.client.dto.request.TitleUpdateRequest
import com.github.danzx.xof.client.dto.response.Page
import com.github.danzx.xof.client.impl.retrofit.service.PostsService
import com.github.danzx.xof.client.impl.retrofit.test.ext.of
import com.github.danzx.xof.client.impl.retrofit.test.ext.successfulResponse
import com.github.danzx.xof.client.impl.retrofit.test.factory.CommentObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.ErrorObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.PaginationObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.PostObjectMother

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
class PostsServiceAdapterTest {

    @MockK lateinit var postsService: PostsService
    @InjectMockKs lateinit var adapter: PostsServiceAdapter

    @Test
    fun `should get() return response body when service returns success response`() {
        val post = PostObjectMother.createPost()
        val expected = Page of post
        val pagination = PaginationObjectMother.createPaginationForFirstPageWithOneResult()
        val q = post.title

        every { postsService.get(q, pagination.page, pagination.size) } returns response(expected)

        val actual = adapter.get(q, pagination)

        actual shouldBe expected
    }

    @Test
    fun `should getById() return response body when service returns success response`() {
        val expected = PostObjectMother.createPost()

        every { postsService.getById(expected.id) } returns response(expected)

        val actual = adapter.getById(expected.id)

        actual shouldNotBe null
        actual shouldBe expected
    }

    @Test
    fun `should getById() return null when service returns 404`() {
        val error = ErrorObjectMother.createJsonNotFoundError<Post>()

        every { postsService.getById(any()) } returns response(error)

        val actual = adapter.getById(1)

        actual shouldBe null
    }

    @Test
    fun `should create() return response body when service returns success response`() {
        val expected = PostObjectMother.createPost()
        val request = CreatePostRequest(expected.title, expected.content, expected.user.id)

        every { postsService.create(request) } returns response(expected)

        val actual = adapter.create(request)

        actual shouldBe expected
    }

    @Test
    fun `should replaceTitle() return response body when service returns success response`() {
        val expected = PostObjectMother.createPost().copy(title = "new title")

        every { postsService.replaceTitle(expected.id, TitleUpdateRequest(expected.title)) } returns response(expected)

        val actual = adapter.replaceTitle(expected.id, expected.title)

        actual shouldBe expected
    }

    @Test
    fun `should replaceContent() return response body when service returns success response`() {
        val expected = PostObjectMother.createPost().copy(content = "new content")

        every { postsService.replaceContent(expected.id, ContentUpdateRequest(expected.content)) } returns response(expected)

        val actual = adapter.replaceContent(expected.id, expected.content)

        actual shouldBe expected
    }

    @Test
    fun `should delete() just runs when service returns success response`() {
        val requestId = 1L

        every { postsService.delete(requestId) } returns successfulResponse()

        adapter.delete(requestId)

        verify { postsService.delete(requestId) }
    }

    @Test
    fun `should getComments() return response body when service returns success response`() {
        val comment = CommentObjectMother.createComment()
        val expected = Page of comment
        val pagination = PaginationObjectMother.createPaginationForFirstPageWithOneResult()

        every { postsService.getComments(comment.postId, pagination.page, pagination.size) } returns response(expected)

        val actual = adapter.getComments(comment.postId, pagination)

        actual shouldBe expected
    }
}
