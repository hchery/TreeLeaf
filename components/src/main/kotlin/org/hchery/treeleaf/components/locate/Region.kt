package org.hchery.treeleaf.components.locate

import org.hchery.treeleaf.components.locate.region.IpRegionHandler
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

interface IpRegion {
    operator fun invoke(ip: String?): String
}

@Service
class MultiPlatformIpRegion(
    private val handler: IpRegionHandler
) : IpRegion {

    override fun invoke(ip: String?): String {
        return handler.handle(ip)
    }
}
