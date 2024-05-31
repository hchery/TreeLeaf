package org.hchery.treeleaf.service.authentication.login

import org.hchery.treeleaf.db.user.User
import org.hchery.treeleaf.http.login.LoginRequest
import org.hchery.treeleaf.http.login.LoginResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

interface Authenticator {
    val next: Authenticator?
    fun authenticate(user: User, request: LoginRequest, addAfter: AddAuthenticatorAfter): LoginResponse
}

@Service("entryPointAuthenticator")
@Primary
class EntryPointAuthenticator(
    @Qualifier("stateCheckAuthenticator") override val next: Authenticator
) : Authenticator {

    override fun authenticate(user: User, request: LoginRequest, addAfter: AddAuthenticatorAfter): LoginResponse {
        return next.authenticate(user, request, addAfter)
    }
}

@Service("finalPointAuthenticator")
class FinalPointAuthenticator : Authenticator {

    override val next: Authenticator? = null

    override fun authenticate(user: User, request: LoginRequest, addAfter: AddAuthenticatorAfter): LoginResponse {
        return loginNoHandler("No login handler for authentication type: ${request.authenticationType.name}")
    }
}
