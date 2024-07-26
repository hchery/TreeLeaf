package org.hchery.treeleaf.components.locate.region

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private val SECTION = arrayOf(
    0x7F, // 127
    0x0A, // 10
    0xAC, // 172
    0x10, // 16
    0x1F, // 31
    0xC0, // 192
    0xA8  // 168
)

private fun isLanIP(ip: String?): Boolean {
    if (ip.isNullOrBlank()) {
        return false
    }
    val (ad0, ad1) = ip.split(".")
        .map { it.toInt() }
        .let { it[0] to it[1] }
    return when(ad0) {
        SECTION[0], SECTION[1] -> true
        SECTION[2] -> ad1 in SECTION[3] .. SECTION[4]
        SECTION[5] -> ad1 == SECTION[6]
        else -> false
    }
}

@Component("lanIpRegionHandler")
class LanIpRegionHandler(
    @Qualifier("ip2RegionIpRegionHandler") override val nextHandler: IpRegionHandler
) : IpRegionHandler {

    override fun handle(ip: String?): String {
        if (isLanIP(ip)) {
            return "LanIP"
        }
        return nextHandler.handle(ip)
    }
}
