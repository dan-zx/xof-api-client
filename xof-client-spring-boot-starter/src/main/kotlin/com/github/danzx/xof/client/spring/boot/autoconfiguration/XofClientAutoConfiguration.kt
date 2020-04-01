package com.github.danzx.xof.client.spring.boot.autoconfiguration

import com.github.danzx.xof.client.impl.retrofit.XofClientRetrofitFactory

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(XofClientProperties::class)
class XofClientAutoConfiguration(private val properties: XofClientProperties) {

    @Bean
    @ConditionalOnMissingBean
    fun xofClient() = XofClientRetrofitFactory().create(properties)
}
