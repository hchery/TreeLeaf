package org.hchery.treeleaf.service.authentication.login.listener

import org.hchery.treeleaf.components.locate.IpRegion
import org.hchery.treeleaf.db.authentication.LoginErrorType
import org.hchery.treeleaf.db.log.LoginLog
import org.hchery.treeleaf.service.authentication.login.LoginEvent
import org.hchery.treeleaf.service.log.login.LoginLogService
import org.springframework.context.ApplicationListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

@Component
class LoginEventLogListener(
    private val loginLogService: LoginLogService,
    private val ipRegion: IpRegion
) : ApplicationListener<LoginEvent> {

    @Async
    override fun onApplicationEvent(event: LoginEvent) {
        val log = toLog(event)
        loginLogService.save(log)
    }

    private fun toLog(event: LoginEvent): LoginLog {
        val log = LoginLog()
        log.userId = event.userId
        log.ipAddr = event.remoteIp
        log.ipRegion = ipRegion(event.remoteIp)
        log.userAgent = event.userAgent
        log.loginTime = event.time
        log.isSuccess = event.loginSuccess
        log.authenticationType = event.authenticationType
        log.errorType = getErrorType(event)
        return log
    }

    private fun getErrorType(event: LoginEvent): LoginErrorType? {
        if (event.loginSuccess) {
            return null
        }
        return event.loginErrorType ?: LoginErrorType.SERVER_ERROR
    }
}
