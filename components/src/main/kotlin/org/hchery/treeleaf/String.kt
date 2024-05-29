package org.hchery.treeleaf

/**
 * DATE: 2024/5/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private val charArray = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ_-.&%$#@23456789".toCharArray()

fun List<Char>.asString(): String {
    return this.joinToString(separator = "")
}

fun stringRandom(lenMin: Int = 8, lenMax: Int = 16): String {
    val len = randomInt(lenMin, lenMax)
    return (1..len)
        .map { charArray[randomInt(0, charArray.size - 1)] }
        .asString()
}
