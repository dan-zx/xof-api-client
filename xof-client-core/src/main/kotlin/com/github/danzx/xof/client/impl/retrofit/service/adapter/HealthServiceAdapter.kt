package com.github.danzx.xof.client.impl.retrofit.service.adapter

import com.github.danzx.xof.client.api.HealthApi
import com.github.danzx.xof.client.exceptions.XofApiException
import com.github.danzx.xof.client.impl.retrofit.ext.get
import com.github.danzx.xof.client.impl.retrofit.service.HealthService

import org.slf4j.LoggerFactory

import java.io.IOException

class HealthServiceAdapter(private val healthService: HealthService) : HealthApi {

    private val log = LoggerFactory.getLogger(HealthServiceAdapter::class.java)

    override val isServiceAvailable: Boolean
        get() {
            return try {
                healthService.check().get().value
            } catch (ex: XofApiException) {
                log.error("Health check returned an error", ex)
                false
            } catch (ex: IOException) {
                log.error("Unable to connect with XOF API", ex)
                false
            }
        }
}
