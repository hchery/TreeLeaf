package org.hchery.treeleaf.components.locate.region

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.net.Inet6Address
import java.net.InetAddress
import java.net.UnknownHostException

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private fun isIPv6(ip: String?) = try {
    val addr = InetAddress.getByName(ip)
    addr is Inet6Address
} catch (_: UnknownHostException) {
    // Ignore exception info print
    /* Only return */false
}

@Component("ipv6IpRegionHandler")
class IPv6IpRegionHandler(
    @Qualifier("lanIpRegionHandler") override val nextHandler: IpRegionHandler
) : IpRegionHandler {

    override fun handle(ip: String?): String {
        if (isIPv6(ip)) {
            return "IPv6"
        }
        return nextHandler.handle(ip)
    }
}
