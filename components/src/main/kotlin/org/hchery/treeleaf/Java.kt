package org.hchery.treeleaf

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.Duration
import java.util.*

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

/**
 * For example:
 *  PT30m
 *  P2d
 */
typealias DurationText = String

fun duration(text: DurationText): Duration {
    return Duration.parse(text)
}

fun nowDate(): Date = Date()

inline fun <reified T> java(): Class<T> {
    return T::class.java
}

inline fun <reified T> slf4j(): Logger {
    return LoggerFactory.getLogger(java<T>())
}
