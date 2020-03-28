package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.dto.User
import com.github.danzx.xof.client.dto.Vote
import com.github.danzx.xof.client.dto.response.Page
import com.github.danzx.xof.client.impl.retrofit.ext.toCreateRequest
import com.github.danzx.xof.client.impl.retrofit.ext.toReplaceRequest
import com.github.danzx.xof.client.impl.retrofit.ext.toRequest
import com.github.danzx.xof.client.impl.retrofit.service.UsersService
import com.github.danzx.xof.client.impl.retrofit.test.ext.successfulResponse
import com.github.danzx.xof.client.impl.retrofit.test.ext.of
import com.github.danzx.xof.client.impl.retrofit.test.factory.CommentObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.ErrorObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.PaginationObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.PostObjectMother
import com.github.danzx.xof.client.impl.retrofit.test.factory.UserObjectMother

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
class UsersServiceAdapterTest {

    @MockK lateinit var usersService: UsersService
    @InjectMockKs lateinit var adapter: UsersServiceAdapter

    @Test
    fun `should getById() return response body when service returns success response`() {
        val expected = UserObjectMother.createUser()

        every { usersService.getById(expected.id) } returns response(expected)

        val actual = adapter.getById(expected.id)

        actual shouldNotBe null
        actual shouldBe expected
    }

    @Test
    fun `should getById() return null when service returns 404`() {
        val error = ErrorObjectMother.createJsonNotFoundError<User>()

        every { usersService.getById(any()) } returns response(error)

        val actual = adapter.getById(1)

        actual shouldBe null
    }

    @Test
    fun `should getByUsername() return response body when service returns success response`() {
        val expected = UserObjectMother.createUser()

        every { usersService.getByUsername(expected.username) } returns response(expected)

        val actual = adapter.getByUsername(expected.username)

        actual shouldNotBe null
        actual shouldBe expected
    }

    @Test
    fun `should getByUsername() return null when service returns 404`() {
        val error = ErrorObjectMother.createJsonNotFoundError<User>()

        every { usersService.getByUsername(any()) } returns response(error)

        val actual = adapter.getByUsername("username")

        actual shouldBe null
    }

    @Test
    fun `should create() return response body when service returns success response`() {
        val expected = UserObjectMother.createUser()
        val request = expected.toCreateRequest()

        every { usersService.create(request) } returns response(expected)

        val actual = adapter.create(request)

        actual shouldBe expected
    }

    @Test
    fun `should replace() return response body when service returns success response`() {
        val expected = UserObjectMother
            .createUser()
            .copy(
                name = "NewName",
                lastName = "NewLastName",
                username = "NewUsername",
                avatarImageUrl = "NewAvatarImageUrl"
            )
        val request = expected.toReplaceRequest()

        every { usersService.replace(expected.id, request) } returns response(expected)

        val actual = adapter.replace(expected.id, request)

        actual shouldBe expected
    }

    @Test
    fun `should delete() just runs when service returns success response`() {
        val requestId = 1L

        every { usersService.delete(requestId) } returns successfulResponse()

        adapter.delete(requestId)

        verify { usersService.delete(requestId) }
    }

    @Test
    fun `should getComments() return response body when service returns success response`() {
        val comment = CommentObjectMother.createComment()
        val expected = Page of comment
        val pagination = PaginationObjectMother.createPaginationForFirstPageWithOneResult()

        every { usersService.getComments(comment.user.id, pagination.page, pagination.size) } returns response(expected)

        val actual = adapter.getComments(comment.user.id, pagination)

        actual shouldBe expected
    }

    @Test
    fun `should getPosts() return response body when service returns success response`() {
        val post = PostObjectMother.createPost()
        val expected = Page of post
        val pagination = PaginationObjectMother.createPaginationForFirstPageWithOneResult()

        every { usersService.getPosts(post.user.id, pagination.page, pagination.size) } returns response(expected)

        val actual = adapter.getPosts(post.user.id, pagination)

        actual shouldBe expected
    }

    @Test
    fun `should voteOnComment() just runs when service returns success response`() {
        val userId = 1L
        val commentId = 1L
        val vote = Vote.Direction.UP
        val voteRequest = vote.toRequest()

        every { usersService.voteOnComment(userId, commentId, voteRequest) } returns successfulResponse()

        adapter.voteOnComment(userId, commentId, vote)

        verify { usersService.voteOnComment(userId, commentId, voteRequest) }
    }

    @Test
    fun `should voteOnPost() just runs when service returns success response`() {
        val userId = 1L
        val postId = 1L
        val vote = Vote.Direction.DOWN
        val voteRequest = vote.toRequest()

        every { usersService.voteOnPost(userId, postId, voteRequest) } returns successfulResponse()

        adapter.voteOnPost(userId, postId, vote)

        verify { usersService.voteOnPost(userId, postId, voteRequest) }
    }
}
