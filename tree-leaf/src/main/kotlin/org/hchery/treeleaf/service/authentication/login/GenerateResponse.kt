package org.hchery.treeleaf.service.authentication.login

import org.hchery.treeleaf.http.login.LoginResponse
import org.hchery.treeleaf.service.authentication.token.AccessTokenService
import org.hchery.treeleaf.service.authentication.token.RefreshTokenService
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/31
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
class LoginResponseGenerator(
    private val accessTokenService: AccessTokenService,
    private val refreshTokenService: RefreshTokenService,
) {

    fun make(userId: String): LoginResponse {
        val response = LoginResponse()
        response.accessToken = accessTokenService.new(userId)
        response.refreshToken = refreshTokenService.new(userId)
        return response
    }
}
