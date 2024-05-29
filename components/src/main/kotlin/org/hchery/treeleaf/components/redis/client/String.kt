package org.hchery.treeleaf.components.redis.client

import org.hchery.treeleaf.DurationText
import org.hchery.treeleaf.duration

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

abstract class StringRedisClient(group: String): ValueRedisClient(group) {

    fun read(key: String): String? = opsRedis(key) { r, k -> r[k] }

    fun write(key: String, expire: DurationText, func: () -> String?) = opsRedis(key) { r, k ->
        func()?.also { r.set(k, it, duration(expire)) }
    }
}
