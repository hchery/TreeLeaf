package org.hchery.treeleaf.components.redis.client

import org.hchery.treeleaf.DurationText

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

abstract class CountRedisClient(group: String) : ValueRedisClient("cnt:$group") {

    fun current(key: String): Long? = opsRedis(key) { r, k -> r[k]?.toLong() }

    fun incr(key: String, expire: DurationText, delta: () -> Long): Long {
        return opsRedis(key) { r, k -> r.increment(k, delta())!!.also { setExpireIfNot(k, expire) } }
    }

    fun decr(key: String, expire: DurationText, delta: () -> Long): Long {
        return opsRedis(key) { r, k -> r.decrement(k, delta())!!.also { setExpireIfNot(k, expire) } }
    }
}
