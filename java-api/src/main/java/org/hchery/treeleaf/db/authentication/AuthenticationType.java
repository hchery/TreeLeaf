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
public enum AuthenticationType implements Serializable {

    PASSWORD(1, "密码登录"),
    ;

    @Serial
    private static final long serialVersionUID = 6080198284450522062L;

    private final int id;
    private final String name;
}
