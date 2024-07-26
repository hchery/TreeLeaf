package org.hchery.treeleaf

import org.apache.commons.lang3.time.DateUtils
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

fun afterDate(date: Date = nowDate(), day: Int = 0, hour: Int = 0, minute: Int = 0, second: Int = 0): Date {
    var newDate = date
    if (day != 0) newDate = DateUtils.addDays(newDate, day)
    if (hour != 0) newDate = DateUtils.addHours(newDate, hour)
    if (minute != 0) newDate = DateUtils.addMinutes(newDate, minute)
    if (second != 0) newDate = DateUtils.addSeconds(newDate, second)
    return newDate
}

inline fun <reified T> java(): Class<T> {
    return T::class.java
}

inline fun <reified T> slf4j(): Logger {
    return LoggerFactory.getLogger(java<T>())
}
