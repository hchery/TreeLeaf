package org.hchery.treeleaf.components.locate.region

import com.maxmind.geoip2.DatabaseReader
import org.hchery.treeleaf.slf4j
import org.hchery.treeleaf.spring.classPathResource
import org.hchery.treeleaf.tuple
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.net.InetAddress

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private const val MmdbFile = "geolite2-city/GeoLite2-City.mmdb"
private const val RegionI18n = "zh-CN"
private val log = slf4j<GeoLite2CityIpRegionHandler>()

@Component("geoLite2CityIpRegionHandler")
class GeoLite2CityIpRegionHandler(
    @Qualifier("finalIpRegionHandler") override val nextHandler: IpRegionHandler
) : IpRegionHandler, InitializingBean, DisposableBean {

    private lateinit var reader: DatabaseReader

    override fun handle(ip: String?): String {
        return read(ip) ?: nextHandler.handle(ip)
    }

    private fun read(ip: String?): String? {
        if (ip.isNullOrBlank()) {
            return null
        }
        return getRegion(ip)
    }

    private fun getRegion(ip: String?) = try {
        val (country, province) = reader.city(InetAddress.getByName(ip))
            .let { tuple(
                it.country.names[RegionI18n],
                it.mostSpecificSubdivision.names[RegionI18n]
            ) }
        concatRegion(country, province)
    } catch (ex: Exception) {
        if (log.isDebugEnabled) {
            log.debug("Failed to region by GeoLite2-City: '$ip'", ex)
        }
        /* Return */ null /* with error */
    }

    private fun concatRegion(country: String?, province: String?): String? {
        if (country.isNullOrBlank()) {
            // 没有国家信息，忽略该数据
            return null
        }
        return if (province.isNullOrBlank()) country else "$country$province"
    }

    override fun afterPropertiesSet() {
        log.info("Opening GeoLite2-City reader with mmdb file: '$MmdbFile'")
        val inputStream = classPathResource(MmdbFile).inputStream
        reader = DatabaseReader.Builder(inputStream).build()
    }

    override fun destroy() {
        log.info("Closing GeoLite2-City reader with mmdb file: '$MmdbFile'")
        reader.close()
    }
}
