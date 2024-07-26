package org.hchery.treeleaf.servlet

import jakarta.servlet.http.HttpServletRequest
import org.hchery.treeleaf.Client
import org.hchery.treeleaf.components.locate.servletRemoteIp
import org.hchery.treeleaf.slf4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.annotation.RequestScope

/**
 * DATE: 2024/5/15
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private val log = slf4j<ClientBuildConfigurer>()

private fun Client.tryRemoteIp(request: HttpServletRequest) {
    try {
        remoteIp = servletRemoteIp(request)
    } catch (ex: Exception) {
        if (log.isDebugEnabled) {
            log.debug("Failed to get remote ip", ex)
        }
    }
}

private fun Client.tryUserAgent(request: HttpServletRequest) {
    userAgent = request.getHeader("User-Agent")
}

private fun Client.tryAll(request: HttpServletRequest): Client {
    tryRemoteIp(request)
    tryUserAgent(request)
    return this
}

@Configuration(proxyBeanMethods = false)
class ClientBuildConfigurer {

    @Bean
    @RequestScope
    fun client(request: HttpServletRequest): Client {
        return Client().tryAll(request)
    }
}
