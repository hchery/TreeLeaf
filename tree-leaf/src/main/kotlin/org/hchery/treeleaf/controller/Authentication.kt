package org.hchery.treeleaf.controller

import org.hchery.treeleaf.http.login.LoginRequest
import org.hchery.treeleaf.http.login.LoginResponse
import org.hchery.treeleaf.service.authentication.login.LoginEntryPoint
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RestController
@RequestMapping("/api/auth/open")
class OpenAuthenticationController(
    private val loginEntryPoint: LoginEntryPoint
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): LoginResponse {
        return loginEntryPoint(request)
    }
}
