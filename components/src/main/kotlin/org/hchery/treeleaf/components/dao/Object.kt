package org.hchery.treeleaf.components.dao

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.NoRepositoryBean

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

/**
 * Data access object
 */
@NoRepositoryBean
interface Dao<T> : MongoRepository<T, String> {
    fun searchById(id: String): T?
}