package org.hchery.treeleaf.db.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * DATE: 2024/5/25
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@AllArgsConstructor
@Getter
public enum LoginErrorType implements Serializable {

    NO_HANDLER(1, 10403, "无效认证类型"),
    NO_SUCH_USER(2, 10404, "用户不存在"),
    PASSWORD_INVALID(3, 10401, "登录密码错误"),
    LOGIN_LIMITED(4, 10403, "限制登录"),
    SERVER_ERROR(5, 10500, "服务故障"),
    ;

    @Serial
    private static final long serialVersionUID = -8442669577262109976L;

    private final int id;
    private final int code;
    private final String text;
}
