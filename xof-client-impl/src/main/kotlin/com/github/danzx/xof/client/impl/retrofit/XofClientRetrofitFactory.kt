package com.github.danzx.xof.client.impl.retrofit

import com.github.danzx.xof.client.XofClient
import com.github.danzx.xof.client.XofClientFactory
import com.github.danzx.xof.client.configuration.XofClientConfiguration
import com.github.danzx.xof.client.impl.retrofit.service.CommentsService
import com.github.danzx.xof.client.impl.retrofit.service.PostsService
import com.github.danzx.xof.client.impl.retrofit.service.UsersService
import com.github.danzx.xof.client.impl.retrofit.service.adapter.CommentsServiceAdapter
import com.github.danzx.xof.client.impl.retrofit.service.adapter.PostsServiceAdapter
import com.github.danzx.xof.client.impl.retrofit.service.adapter.UsersServiceAdapter

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level

import org.slf4j.LoggerFactory

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

import java.io.File

class XofClientRetrofitFactory(configuration: XofClientConfiguration) : XofClientFactory(configuration) {

    override fun create(): XofClient {
        val retrofit = buildRetrofit()
        val usersApi = UsersServiceAdapter(retrofit.create(UsersService::class.java))
        val postsApi = PostsServiceAdapter(retrofit.create(PostsService::class.java))
        val commentsApi = CommentsServiceAdapter(retrofit.create(CommentsService::class.java))
        return XofClient(usersApi, postsApi, commentsApi)
    }

    private fun buildRetrofit() = 
        Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(configuration.baseUrl)
            .client(buildOkHttpClient())
            .build()

    private fun buildOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(configuration.connection.readTimeout)
            .writeTimeout(configuration.connection.writeTimeout)
            .connectTimeout(configuration.connection.connectTimeout)
            .callTimeout(configuration.connection.callTimeout)

        if (configuration.logger.isEnabled) configureLogging(builder)
        if (configuration.cache.isEnabled) configureCache(builder)

        return builder.build()
    }

    private fun configureLogging(okHttpClientBuilder: OkHttpClient.Builder) {
        val slf4jLogger = LoggerFactory.getLogger(HttpLoggingInterceptor::class.java)
        val interceptor = HttpLoggingInterceptor(slf4jLogger::info)
        interceptor.level = Level.valueOf(configuration.logger.level.name)
        okHttpClientBuilder.addNetworkInterceptor(interceptor)
    }

    private fun configureCache(okHttpClientBuilder: OkHttpClient.Builder) {
        val tempDirectory = File.createTempFile("okhttp-cache", ".tmp")
        val cache = Cache(tempDirectory, configuration.cache.cacheMaxSizeInBytes)
        okHttpClientBuilder.cache(cache)
    }
}