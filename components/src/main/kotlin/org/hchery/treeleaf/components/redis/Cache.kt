package org.hchery.treeleaf.components.redis

import org.hchery.treeleaf.DurationText
import org.hchery.treeleaf.duration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.cache.RedisCache
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

@Component
@Primary
class DurationRedisCacheManager(
    writer: RedisCacheWriter,
    conf: RedisCacheConfiguration
) : RedisCacheManager(writer, conf) {

    /**
     * Add expire time support
     * For example:
     *  cacheName: user -> cacheName: user#PT30m
     *  for set user cache expire as 30 minutes
     */
    override fun createRedisCache(
        name: String,
        cacheConfiguration: RedisCacheConfiguration?
    ): RedisCache {
        val nks = name.split("#")
        if (nks.size < 2) {
            return super.createRedisCache(
                name,
                cacheConfiguration
            )
        }
        val expire: DurationText = nks[1]
        return super.createRedisCache(
            nks[0],
            cacheConfiguration?.entryTtl(duration(expire))
        )
    }
}
