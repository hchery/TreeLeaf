package org.hchery.treeleaf.dao

import org.hchery.treeleaf.components.dao.Dao
import org.hchery.treeleaf.db.IdOnlyDbModel
import org.hchery.treeleaf.db.user.User
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.mongodb.repository.Query

/**
 * DATE: 2024/5/21
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
private const val CacheUserId = "user:id"
private const val CacheUser = "user"

interface UserDao : Dao<User> {

    @Query(value = "{email: ?0}", fields = "{id: 1}")
    @Cacheable(cacheNames = [CacheUserId], key = "#email")
    fun searchIdByEmail(email: String): IdOnlyDbModel?

    @Cacheable(cacheNames = ["$CacheUser#PT30m"], key = "#id")
    override fun searchById(id: String): User?

    @CacheEvict(cacheNames = [CacheUser], key = "#entity.id")
    override fun <S : User?> save(entity: S & Any): S & Any
}