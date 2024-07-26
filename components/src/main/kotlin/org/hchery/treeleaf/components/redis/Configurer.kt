package org.hchery.treeleaf.components.redis

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.time.Duration

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Configuration(proxyBeanMethods = false)
class RedisCacheConfigurer {

    @Bean
    fun cacheWriter(factory: RedisConnectionFactory): RedisCacheWriter {
        return RedisCacheWriter.nonLockingRedisCacheWriter(factory)
    }

    @Bean
    fun cacheConfiguration(@Value("\${tree.leaf.cache.prefix}") prefix: String): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig()
            .serializeKeysWith(RedisSerializationContext.string().keySerializationPair)
            .serializeValuesWith(RedisSerializationContext.java().valueSerializationPair)
            .prefixCacheNameWith(prefix)
            .computePrefixWith { "${prefix}:$it:" }
            .entryTtl(Duration.ofMinutes(5))
    }

    @Bean
    fun stringRedisTemplate(factory: RedisConnectionFactory): StringRedisTemplate {
        return StringRedisTemplate(factory)
    }
}
