package com.github.danzx.xof.client

import com.github.danzx.xof.client.api.CommentsApi
import com.github.danzx.xof.client.api.HealthApi
import com.github.danzx.xof.client.api.PostsApi
import com.github.danzx.xof.client.api.UsersApi
import com.github.danzx.xof.client.configuration.XofClientConfiguration
import com.github.danzx.xof.client.configuration.dsl.XofClientConfigurationBuilder

import java.util.ServiceLoader

data class XofClient(
    val usersApi: UsersApi,
    val postsApi: PostsApi,
    val commentsApi: CommentsApi,
    private val healthApi: HealthApi) {

    val isServiceAvailable
        get() = healthApi.isServiceAvailable


    companion object {
        fun newInstance() = spiCreate()

        fun overriding(setup: XofClientConfigurationBuilder.() -> Unit): XofClient {
            val configBuilder = XofClientConfigurationBuilder()
            configBuilder.setup()
            return spiCreate(configBuilder.build())
        }

        private fun spiCreate(config: XofClientConfiguration = XofClientConfigurationBuilder().build()) =
            ServiceLoader.load(XofClientFactory::class.java).first().create(config)
    }
}
