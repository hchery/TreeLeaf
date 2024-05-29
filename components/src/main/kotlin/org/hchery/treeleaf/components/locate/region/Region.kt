package org.hchery.treeleaf.components.locate.region

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

interface IpRegionHandler {
    val nextHandler: IpRegionHandler?
    fun handle(ip: String?): String
}

@Component("entryIpRegionHandler")
@Primary
class EntryIpRegionHandler(
    @Qualifier("ipv6IpRegionHandler") override val nextHandler: IpRegionHandler
) : IpRegionHandler {

    override fun handle(ip: String?): String {
        if (ip.isNullOrBlank()) {
            return ""
        }
        return nextHandler.handle(ip)
    }
}

@Component("finalIpRegionHandler")
class FinalIpRegionHandler : IpRegionHandler {

    override val nextHandler: IpRegionHandler? = null

    override fun handle(ip: String?): String {
        return ""
    }
}

