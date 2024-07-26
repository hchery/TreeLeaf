package org.hchery.treeleaf.service.authentication.token

import org.hchery.treeleaf.db.key.AesKeyDbModel
import org.hchery.treeleaf.service.crypto.AesCrypto
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

@Component
class RefreshTokenCrypto : AesCrypto("refresh-token") {

    override fun newKey(makeKey: () -> ByteArray): AesKeyDbModel {
        val model = AesKeyDbModel()
        model.name = super.name
        model.showName = "Refresh Token Key"
        model.desc = "Refresh token encrypt key"
        model.key = makeKey()
        return model
    }
}

@Component
class AccessTokenCrypto : AesCrypto("access-token") {

    override fun newKey(makeKey: () -> ByteArray): AesKeyDbModel {
        val model = AesKeyDbModel()
        model.name = super.name
        model.showName = "Access Token Key"
        model.desc = "Access token encrypt key"
        model.key = makeKey()
        return model
    }
}
