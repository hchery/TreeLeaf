package org.hchery.treeleaf.spring

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver

/**
 * DATE: 2024/5/23
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

interface ServletLogic {
    operator fun invoke(request: HttpServletRequest, response: HttpServletResponse, logic: () -> Any?)
}

private fun HttpServletResponse.writeAndFlush(bytes: ByteArray) {
    outputStream.write(bytes)
    outputStream.flush()
}

@Component
class SpringServletLogic(
    private val objectMapper: ObjectMapper,
    private val handlerExceptionResolver: HandlerExceptionResolver
) : ServletLogic {

    private val json: (Any?) -> ByteArray = objectMapper::writeValueAsBytes

    override fun invoke(request: HttpServletRequest, response: HttpServletResponse, logic: () -> Any?) {
        try {
            val returnValue = logic()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writeAndFlush(json(returnValue))
        } catch (ex: Exception) {
            // Forward to spring global exception handler
            handlerExceptionResolver.resolveException(request, response, null, ex)
        }
    }
}
