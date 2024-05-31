package org.hchery.treeleaf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

@SpringBootApplication
@EnableAsync
@EnableMongoRepositories
@EnableMongoAuditing
@EnableCaching
@EnableScheduling
@EnableTransactionManagement
class TreeLeafApplicationLauncher

fun main(args: Array<String>) {
    runApplication<TreeLeafApplicationLauncher>(*args)
}
