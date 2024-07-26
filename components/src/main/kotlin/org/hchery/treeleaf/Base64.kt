package org.hchery.treeleaf

import java.util.*

/**
 * DATE: 2024/5/31
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

fun toBase64(bytes: ByteArray): String {
    return Base64.getEncoder().encodeToString(bytes)
}

fun fromBase64(base64: String): ByteArray {
    return Base64.getDecoder().decode(base64)
}
