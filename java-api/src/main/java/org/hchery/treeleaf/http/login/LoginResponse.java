package org.hchery.treeleaf.http.login;

import lombok.Data;
import org.hchery.treeleaf.http.ApiResponse;

import java.io.Serial;

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public class LoginResponse implements ApiResponse {
    @Serial
    private static final long serialVersionUID = 3034923934444502936L;

    private String refreshToken;
    private String accessToken;
}
