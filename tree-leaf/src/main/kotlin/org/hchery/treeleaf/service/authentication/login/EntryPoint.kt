package org.hchery.treeleaf.service.authentication.login

import org.hchery.treeleaf.Client
import org.hchery.treeleaf.db.authentication.AuthenticationType
import org.hchery.treeleaf.db.authentication.LoginErrorType
import org.hchery.treeleaf.db.user.User
import org.hchery.treeleaf.http.login.LoginRequest
import org.hchery.treeleaf.http.login.LoginResponse
import org.hchery.treeleaf.nowDate
import org.hchery.treeleaf.service.user.UserService
import org.hchery.treeleaf.spring.AppEvent
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Date

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

interface LoginEntryPoint {
    operator fun invoke(request: LoginRequest): LoginResponse
}

typealias AuthenticatorAfter = () -> Unit
typealias AddAuthenticatorAfter = (AuthenticatorAfter) -> Unit

@Service
class LoginEntryPointService(
    private val ctx: ApplicationContext,
    private val client: Client,
    private val authenticator: Authenticator,
    private val userService: UserService
) : LoginEntryPoint {

    @Transactional
    override fun invoke(request: LoginRequest): LoginResponse {
        val user = fetchUser(request)
        val hooks = mutableListOf<AuthenticatorAfter>()
        val event = createEvent(user, request)
        try {
            return authenticator.authenticate(user, request, hooks::add).also {
                hooks.forEach { it() }
                event.makeCompleted()
            }
        } catch (ex: Exception) {
            event.makeError(ex)
            throw ex
        } finally {
            ctx.publishEvent(event)
        }
    }

    private fun createEvent(user: User, request: LoginRequest): LoginEvent {
        val loginEvent = LoginEvent(this)
        loginEvent.userId = user.id
        loginEvent.remoteIp = client.remoteIp
        loginEvent.userAgent = client.userAgent
        loginEvent.time = nowDate()
        loginEvent.authenticationType = request.authenticationType
        return loginEvent
    }

    private fun fetchUser(request: LoginRequest): User {
        return userService.getByEmail(request.email)
            ?: loginNoSuchUser("No such user by email: ${request.email}")
    }
}

@Suppress("serial")
class LoginEvent(src: Any) : AppEvent(src) {

    var loginErrorCause: Exception? = null
    var loginErrorType: LoginErrorType? = null
    var loginSuccess: Boolean = false

    lateinit var userId: String
    lateinit var remoteIp: String
    lateinit var userAgent: String
    lateinit var time: Date
    lateinit var authenticationType: AuthenticationType
}

private fun LoginEvent.makeCompleted() {
    loginErrorCause = null
    loginSuccess = true
    loginErrorType = null
}

private fun LoginEvent.makeError(ex: Exception) {
    loginErrorCause = ex
    loginSuccess = false
    loginErrorType = if (ex is LoginException) ex.type else null
}
