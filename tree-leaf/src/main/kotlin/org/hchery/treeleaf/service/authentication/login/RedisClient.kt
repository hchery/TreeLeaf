package org.hchery.treeleaf.service.authentication.login

import org.hchery.treeleaf.components.redis.client.CountRedisClient
import org.hchery.treeleaf.components.redis.client.StringRedisClient
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
class LoginLimit : StringRedisClient("login-limit")

@Component
class PasswordInvalidCounter : CountRedisClient("pwd-invalid")
