package org.hchery.treeleaf.components.dao

import org.bson.types.ObjectId

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

/**
 * Data access service
 */
abstract class Das<T, DAO : Dao<T>>(protected val dao: DAO) {
    fun getById(id: String): T? = dao.searchById(id)
    fun <S : T & Any> save(entity: S): S = dao.save(entity)
    fun delById(id: String) = dao.deleteById(id)
}
