package org.hchery.treeleaf.service.authentication.token

import org.hchery.treeleaf.dao.AccessTokenDao
import org.hchery.treeleaf.toBase64
import org.springframework.stereotype.Service
import java.util.*

/**
 * DATE: 2024/5/31
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private fun make(): String {
    return UUID.randomUUID().toString()
        .replace("-", "")
}

@Service
class AccessTokenService(
    private val dao: AccessTokenDao,
    private val crypto: AccessTokenCrypto
) {

    fun new(userId: String): String {
        val token = make()
        dao.save(token) { userId }
        return encode(token)
    }

    private fun encode(token: String): String {
        val binary = token.toByteArray(Charsets.UTF_8)
        return toBase64(crypto.encode(binary))
    }
}
