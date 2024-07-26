package org.hchery.treeleaf.error

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

fun <T> badRequest(
    desc: ErrorDesc = "请求参数错误",
    message: String?
): T {
    throw BizException(400, desc, message, NO_CAUSE)
}

fun <T> noAuthorized(
    desc: ErrorDesc = "登录已失效",
    message: String?
): T {
    throw BizException(401, desc, message, NO_CAUSE)
}

fun <T> serverError(
    desc: ErrorDesc = "服务内部错误",
    message: String?,
    cause: Throwable
): T {
    throw SeriousException(500, desc, message, cause)
}
