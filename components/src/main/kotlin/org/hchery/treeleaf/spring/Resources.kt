package org.hchery.treeleaf.spring

import org.springframework.core.io.ClassPathResource
import java.io.ByteArrayOutputStream
import java.io.InputStream

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

fun binaryClassPathResource(path: String): ByteArray {
    return classPathResource(path).read {
        ByteArrayOutputStream().use {
            transferTo(it)
            it.toByteArray()
        }
    }
}

fun classPathResource(path: String): ClassPathResource {
    return ClassPathResource(path)
}

private fun <T> ClassPathResource.read(transfer: InputStream.() -> T): T {
    return inputStream.use { transfer(it) }
}
