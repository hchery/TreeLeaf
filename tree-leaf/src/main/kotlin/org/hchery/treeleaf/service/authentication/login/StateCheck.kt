package org.hchery.treeleaf.service.authentication.login

import org.hchery.treeleaf.db.user.User
import org.hchery.treeleaf.http.login.LoginRequest
import org.hchery.treeleaf.http.login.LoginResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service("stateCheckAuthenticator")
class StateCheckAuthenticator(
    @Qualifier("passwordCheckAuthenticator") override val next: Authenticator,
    private val loginLimit: LoginLimit
) : Authenticator {

    override fun authenticate(user: User, request: LoginRequest, addAfter: AddAuthenticatorAfter): LoginResponse {
        if (loginLimit.has(user.id)) {
            return loginLimited("Login limited for user [email: ${user.email}, id: ${user.id}]")
        }
        return next.authenticate(user, request, addAfter)
    }
}
