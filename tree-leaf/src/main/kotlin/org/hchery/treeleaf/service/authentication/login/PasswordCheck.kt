package org.hchery.treeleaf.service.authentication.login

import org.hchery.treeleaf.db.authentication.AuthenticationType
import org.hchery.treeleaf.db.user.User
import org.hchery.treeleaf.event.LoginLimitEvent
import org.hchery.treeleaf.http.login.LoginRequest
import org.hchery.treeleaf.http.login.LoginResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service("passwordCheckAuthenticator")
class PasswordCheckAuthenticator(
    @Qualifier("finalPointAuthenticator") override val next: Authenticator,
    private val ctx: ApplicationContext,
    private val pwdInvalidCnt: PasswordInvalidCounter,
    private val passwordEncoder: PasswordEncoder,
    private val loginResponseGenerator: LoginResponseGenerator
) : Authenticator {

    override fun authenticate(user: User, request: LoginRequest, addAfter: AddAuthenticatorAfter): LoginResponse {
        if (request.authenticationType != AuthenticationType.PASSWORD) {
            return next.authenticate(user, request, addAfter)
        }
        return doAuthenticate(user, request, addAfter)
    }

    private fun doAuthenticate(user: User, request: LoginRequest, addAfter: AddAuthenticatorAfter): LoginResponse {
        if (!passwordEncoder.matches(request.password, user.password)) {
            return doAuthenticateError(user)
        }
        addAfter { pwdInvalidCnt.delete(user.id) }
        return loginResponseGenerator.make(user.id)
    }

    private fun doAuthenticateError(user: User): LoginResponse {
        if (pwdInvalidCnt.incr(user.id, "PT2m") { 1 } >= 5) {
            ctx.publishEvent(LoginLimitEvent(this).apply { userId = user.id })
            pwdInvalidCnt.delete(user.id)
        }
        return loginPasswordInvalid("Login password invalid [email: ${user.email}, id: ${user.id}]")
    }
}
