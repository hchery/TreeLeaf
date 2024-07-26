package org.hchery.treeleaf.components.redis

import jakarta.annotation.PostConstruct
import org.hchery.treeleaf.slf4j
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private val log = slf4j<RedisKeepAlive>()

@Component
class RedisKeepAlive(private val stringRedisTemplate: StringRedisTemplate) {

    @Scheduled(cron = "0 0/1 * * * *")
    @PostConstruct
    fun keepAlive() {
        stringRedisTemplate.execute {
            it.ping()
            if (log.isDebugEnabled) {
                log.debug("Redis keep alive ping sent.")
            }
        }
    }
}
