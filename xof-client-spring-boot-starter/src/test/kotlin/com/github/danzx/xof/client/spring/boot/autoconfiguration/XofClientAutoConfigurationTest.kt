package com.github.danzx.xof.client.spring.boot.autoconfiguration

import com.github.danzx.xof.client.XofClient
import com.github.danzx.xof.client.XofClientFactory
import com.github.danzx.xof.client.configuration.XofClientConfiguration.Logger.Level.HEADERS
import com.github.danzx.xof.client.ext.megabytes

import io.kotlintest.should
import io.kotlintest.shouldBe

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit.jupiter.SpringExtension

import ru.yole.kxdate.milliseconds
import ru.yole.kxdate.minutes
import ru.yole.kxdate.nanoseconds
import ru.yole.kxdate.seconds

import java.util.Optional

@SpringBootTest(
    "xof-client.base-url=http://localhost:8080/api/v1/",
    "xof-client.connection.read-timeout=3m",
    "xof-client.connection.write-timeout=200ms",
    "xof-client.connection.connect-timeout=30s",
    "xof-client.connection.call-timeout=10ns",
    "xof-client.logger.enabled=true",
    "xof-client.logger.level=headers",
    "xof-client.cache.enabled=true",
    "xof-client.cache.size=5MB",
    "spring.main.banner-mode=off"
)
@ExtendWith(SpringExtension::class)
class XofClientAutoConfigurationTest {

    @Autowired lateinit var properties: Optional<XofClientProperties>
    @Autowired lateinit var xofClient: Optional<XofClient>

    @Test
    fun `should auto-configuration must create properties`() {
        properties.isPresent shouldBe true
        properties.get() should {
            it.baseUrl shouldBe "http://localhost:8080/api/v1/"
            it.connection.readTimeout shouldBe 3.minutes
            it.connection.writeTimeout shouldBe 200.milliseconds
            it.connection.connectTimeout shouldBe 30.seconds
            it.connection.callTimeout shouldBe 10.nanoseconds
            it.logger.isEnabled shouldBe true
            it.logger.level shouldBe HEADERS
            it.cache.isEnabled shouldBe true
            it.cache.sizeInBytes shouldBe 5.megabytes
        }
    }

    @Test
    fun `should auto-configuration must create XofClient`() {
        xofClient.isPresent shouldBe true
    }

    @Configuration
    @EnableAutoConfiguration
    class ContextConfiguration
}