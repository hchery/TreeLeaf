package org.hchery.treeleaf.service.authentication.token

import org.hchery.treeleaf.afterDate
import org.hchery.treeleaf.dao.RefreshTokenDao
import org.hchery.treeleaf.db.authentication.RefreshToken
import org.hchery.treeleaf.toBase64
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets

/**
 * DATE: 2024/5/31
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private fun RefreshToken.enable() {
    isLogout = false
    isDisabled = false
    isIllegal = false
}

@Service
class RefreshTokenService(
    private val dao: RefreshTokenDao,
    private val crypto: RefreshTokenCrypto
) {

    fun new(userId: String): String {
        val token = RefreshToken()
        token.userId = userId
        token.expireTime = afterDate(minute = 30)
        token.enable()
        return encode(dao.save(token))
    }

    private fun encode(token: RefreshToken): String {
        val binary = token.id.toByteArray(StandardCharsets.UTF_8)
        return toBase64(crypto.encode(binary))
    }
}
