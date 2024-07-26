package org.hchery.treeleaf.components.redis.client

import org.hchery.treeleaf.DurationText
import org.hchery.treeleaf.duration
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ValueOperations

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

abstract class ValueRedisClient(group: String) : RedisClient(group) {

    fun delete(key: String) = valueRedis(key) { r, k -> r.delete(k) }

    fun has(key: String): Boolean = valueRedis(key) { r, k -> r.hasKey(k) }

    protected fun setExpireIfNot(intactKey: String, expire: DurationText) {
        rawRedis {
            if (it.getExpire(intactKey) == -1L) {
                it.expire(intactKey, duration(expire))
            }
        }
    }

    private fun <T> valueRedis(key: String, func: (StringRedisTemplate, String) -> T): T {
        return useRedis {r, k -> func(r, "$k:$key")}
    }

    protected fun <T> opsRedis(key: String, func: (ValueOperations<String, String>, String) -> T): T {
        return valueRedis(key) { r, k -> func(r.opsForValue(), k) }
    }
}
