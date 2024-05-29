package org.hchery.treeleaf.service.crypto

import org.hchery.treeleaf.dao.AesKeyDao
import org.hchery.treeleaf.dao.CryptoKeyDao
import org.hchery.treeleaf.db.key.AesKeyDbModel
import org.hchery.treeleaf.db.key.KeyDbModel
import org.springframework.stereotype.Service
import javax.crypto.KeyGenerator

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

interface KeyResolve<T : KeyDbModel> {
    operator fun invoke(keyName: String, func: () -> T): T
}

abstract class AbstractKeyService<T : KeyDbModel>(private val dao: CryptoKeyDao<T>) : KeyResolve<T> {

    private val keyMap = dao.findAll().associateBy { it.name }.toMutableMap()

    override fun invoke(keyName: String, func: () -> T): T {
        return keyMap[keyName] ?: func().also { keyMap[keyName] = dao.save(it) }
    }
}

internal fun makeNewAesKey(): ByteArray {
    val keyGenerator = KeyGenerator.getInstance("AES").apply { init(256) }
    return keyGenerator.generateKey().encoded
}

interface AesKeyResolve : KeyResolve<AesKeyDbModel>

@Service
class AesKeyService(dao: AesKeyDao): AbstractKeyService<AesKeyDbModel>(dao), AesKeyResolve
