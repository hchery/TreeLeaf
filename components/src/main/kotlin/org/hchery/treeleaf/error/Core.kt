package org.hchery.treeleaf.error

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
typealias ErrorCode = Int
typealias ErrorDesc = String

val NO_CAUSE: Throwable? = null

@Suppress("serial")
abstract class TreeLeafException(
    val code: ErrorCode,
    val desc: ErrorDesc,
    message: String?,
    cause: Throwable?
): RuntimeException(message, cause, true, false)

@Suppress("serial")
open class BizException(
    code: ErrorCode,
    desc: ErrorDesc,
    message: String?,
    cause: Throwable?
): TreeLeafException(code, desc, message, cause)

@Suppress("serial")
open class SeriousException(
    code: ErrorCode,
    desc: ErrorDesc,
    message: String?,
    cause: Throwable?
): TreeLeafException(code, desc, message, cause)
