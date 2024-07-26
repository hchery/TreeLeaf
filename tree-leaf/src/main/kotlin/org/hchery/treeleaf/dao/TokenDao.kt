package org.hchery.treeleaf.dao

import org.hchery.treeleaf.components.dao.Dao
import org.hchery.treeleaf.components.redis.client.StringRedisClient
import org.hchery.treeleaf.db.authentication.RefreshToken
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/31
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private const val CacheAccessToken = "token:access"
private const val CacheRefreshToken = "token:refresh"

interface RefreshTokenDao : Dao<RefreshToken> {

    @CacheEvict(cacheNames = [CacheRefreshToken], key = "#entity.id")
    override fun <S : RefreshToken?> save(entity: S & Any): S & Any

    @Cacheable(cacheNames = [CacheRefreshToken], key = "#id")
    override fun searchById(id: String): RefreshToken?
}

@Service
class AccessTokenDao : StringRedisClient("token:access") {

    fun save(id: String, func: () -> String) {
        write(id, "PT5m", func)
    }
}
