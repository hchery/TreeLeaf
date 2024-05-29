package org.hchery.treeleaf.components.redis.client

import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.StringRedisTemplate

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

abstract class RedisClient(private val group: String) {

    @Resource
    private lateinit var stringRedisTemplate: StringRedisTemplate

    @Value("\${tree.leaf.cache.prefix}")
    private lateinit var prefix: String

    protected fun <T> useRedis(func: (StringRedisTemplate, String) -> T): T {
        return func(stringRedisTemplate, "$prefix:$group")
    }

    protected fun <T> rawRedis(func: (StringRedisTemplate) -> T): T {
        return func(stringRedisTemplate)
    }
}
