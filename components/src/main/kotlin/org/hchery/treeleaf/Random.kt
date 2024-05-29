package org.hchery.treeleaf

import java.util.Random
import java.util.concurrent.ThreadLocalRandom

/**
 * DATE: 2024/5/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private fun threadRandom(): Random = ThreadLocalRandom.current()

fun randomInt(min: Int, max: Int): Int {
    val random = threadRandom()
    return random.nextInt(max - min + 1) + min
}
