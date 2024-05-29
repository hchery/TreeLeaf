package org.hchery.treeleaf.service.authentication.login.listener

import org.hchery.treeleaf.event.LoginLimitCleanEvent
import org.hchery.treeleaf.event.LoginLimitEvent
import org.hchery.treeleaf.service.authentication.login.LoginLimit
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
class LoginLimitListener(
    private val loginLimit: LoginLimit
) : ApplicationListener<LoginLimitEvent> {

    override fun onApplicationEvent(event: LoginLimitEvent) {
        val userId = event.userId
        loginLimit.write(userId, "PT30m") { userId }
    }
}

@Component
class LoginLimitCleanListener(
    private val loginLimit: LoginLimit
) : ApplicationListener<LoginLimitCleanEvent> {

    override fun onApplicationEvent(event: LoginLimitCleanEvent) {
        loginLimit.delete(event.userId)
    }
}
