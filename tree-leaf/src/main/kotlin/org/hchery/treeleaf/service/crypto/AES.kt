package org.hchery.treeleaf.service.crypto

import jakarta.annotation.Resource
import org.hchery.treeleaf.db.key.AesKeyDbModel
import org.hchery.treeleaf.slf4j
import org.springframework.beans.factory.InitializingBean
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
private val log = slf4j<AesCrypto>()

abstract class AesCrypto(protected val name: String) : InitializingBean {

    @Resource
    private lateinit var aesKeyResolve: AesKeyResolve

    private lateinit var keyModel: AesKeyDbModel

    protected abstract fun newKey(makeKey: () -> ByteArray): AesKeyDbModel

    fun encode(data: ByteArray): ByteArray {
        return crypto(Cipher.ENCRYPT_MODE).run {
            doFinal(data)
        }
    }

    fun decode(data: ByteArray): ByteArray {
        return crypto(Cipher.DECRYPT_MODE).run {
            doFinal(data)
        }
    }

    private fun crypto(mode: Int): Cipher {
        val key = SecretKeySpec(keyModel.key, "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        return cipher.apply { init(mode, key) }
    }

    override fun afterPropertiesSet() {
        keyModel = aesKeyResolve(name) {
            log.info("Initializing aes crypto key for: '$name'.")
            newKey(::makeNewAesKey)
        }
    }
}
