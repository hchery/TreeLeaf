package org.hchery.treeleaf.service.authentication.login

import org.hchery.treeleaf.db.authentication.LoginErrorType
import org.hchery.treeleaf.error.BizException
import org.hchery.treeleaf.error.ErrorDesc
import org.hchery.treeleaf.error.NO_CAUSE

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Suppress("serial")
class LoginException(
    desc: ErrorDesc,
    message: String,
    val type: LoginErrorType
) : BizException(type.code, desc, message, NO_CAUSE)

internal fun <T> loginNoSuchUser(message: String): T {
    throw LoginException(
        desc = "用户名或密码错误",
        message = message,
        type = LoginErrorType.NO_SUCH_USER
    )
}

internal fun <T> loginNoHandler(message: String): T {
    throw LoginException(
        desc = "不支持的认证方式",
        message = message,
        type = LoginErrorType.NO_HANDLER
    )
}

internal fun <T> loginLimited(message: String): T {
    throw LoginException(
        desc = "当前用户已被限制登录",
        message = message,
        type = LoginErrorType.LOGIN_LIMITED
    )
}

internal fun <T> loginPasswordInvalid(message: String): T {
    throw LoginException(
        desc = "用户名或密码错误",
        message = message,
        type = LoginErrorType.PASSWORD_INVALID
    )
}
