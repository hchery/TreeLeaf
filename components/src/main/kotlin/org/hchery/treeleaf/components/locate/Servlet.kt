package org.hchery.treeleaf.components.locate

import jakarta.servlet.http.HttpServletRequest

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private val IpHeaders = arrayOf(
    "X-Real-IP",
    "x-Forwarded-For",
    "Proxy-Client-IP",
    "WL-Proxy-Client-IP"
)

fun servletRemoteIp(request: HttpServletRequest): String? {
    val ip = fetchHeaderIp(request) ?: return request.remoteAddr
    val idx = ip.indexOf(',')
    return if (idx >= 0) ip.substring(0, idx) else ip
}

private fun fetchHeaderIp(request: HttpServletRequest): String? {
    return IpHeaders.map { request.getHeader(it) }
        .firstOrNull { isValidIp(it) }
}

private fun isValidIp(ip: String?): Boolean {
    return !ip.isNullOrBlank()
        && !"unknown".equals(ip, ignoreCase = true)
}
