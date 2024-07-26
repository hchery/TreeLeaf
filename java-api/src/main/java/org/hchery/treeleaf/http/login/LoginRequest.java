package org.hchery.treeleaf.http.login;

import lombok.Data;
import org.hchery.treeleaf.db.authentication.AuthenticationType;
import org.hchery.treeleaf.http.ApiRequest;

import java.io.Serial;

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public class LoginRequest implements ApiRequest {
    @Serial
    private static final long serialVersionUID = -5910667206997833693L;

    private String email;
    private String password;
    private AuthenticationType authenticationType = AuthenticationType.PASSWORD;
}
