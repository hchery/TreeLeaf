package org.hchery.treeleaf.components.locate.region

import org.hchery.treeleaf.slf4j
import org.hchery.treeleaf.spring.binaryClassPathResource
import org.hchery.treeleaf.tuple
import org.lionsoul.ip2region.xdb.Searcher
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private const val XdbPath = "ip2region/ip2region.xdb"
private val log = slf4j<Ip2RegionIpRegionHandler>()

@Component("ip2RegionIpRegionHandler")
class Ip2RegionIpRegionHandler(
    @Qualifier("geoLite2CityIpRegionHandler") override val nextHandler: IpRegionHandler
) : IpRegionHandler, InitializingBean, DisposableBean {

    private lateinit var searcher: Searcher

    override fun handle(ip: String?): String {
        return search(ip) ?: nextHandler.handle(ip)
    }

    private fun search(ip: String?): String? {
        if (ip.isNullOrBlank()) {
            return null
        }
        return getRegion(ip)
    }

    private fun getRegion(ip: String?) = try {
        if (log.isDebugEnabled) {
            log.debug("Region by ip2region: '$ip'")
        }
        val (country, province, city) = searcher.search(ip).split("|")
            .let { tuple(
                it[0],
                it[2],
                it[3]
            ) }
        concatRegion(country, province, city)
    } catch (ex: Exception) {
        if (log.isDebugEnabled) {
            log.debug("Failed to region by ip2region: '$ip'", ex)
        }
        /* Return */ null /* with error */
    }

    private fun concatRegion(country: String, province: String, city: String): String? {
        if ("中国" != country) {
            // 非国内地区不使用此定位方式
            return null
        }
        if (province.isBlank()) {
            // 没有省份信息，忽略该数据
            return null
        }
        return if (city.isBlank()) province else "$province$city"
    }

    override fun afterPropertiesSet() {
        log.info("Opening Ip2Region searcher with xdb file: '$XdbPath'")
        val xdbBuffer = binaryClassPathResource(XdbPath)
        searcher = Searcher.newWithBuffer(xdbBuffer)
    }

    override fun destroy() {
        log.info("Closing Ip2Region searcher with xdb file: '$XdbPath'")
        searcher.close()
    }
}
