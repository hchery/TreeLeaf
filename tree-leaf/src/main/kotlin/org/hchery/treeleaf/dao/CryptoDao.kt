package org.hchery.treeleaf.dao

import org.hchery.treeleaf.components.dao.Dao
import org.hchery.treeleaf.db.key.AesKeyDbModel
import org.hchery.treeleaf.db.key.KeyDbModel
import org.springframework.data.repository.NoRepositoryBean

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@NoRepositoryBean
interface CryptoKeyDao<T : KeyDbModel> : Dao<T>

interface AesKeyDao : CryptoKeyDao<AesKeyDbModel>
