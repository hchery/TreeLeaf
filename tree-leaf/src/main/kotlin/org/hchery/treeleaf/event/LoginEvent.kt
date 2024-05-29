package org.hchery.treeleaf.event

import org.hchery.treeleaf.spring.AppEvent

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

@Suppress("serial")
class LoginLimitEvent(src: Any) : AppEvent(src) {
    lateinit var userId: String
}

@Suppress("serial")
class LoginLimitCleanEvent(src: Any) : AppEvent(src) {
    lateinit var userId: String
}
