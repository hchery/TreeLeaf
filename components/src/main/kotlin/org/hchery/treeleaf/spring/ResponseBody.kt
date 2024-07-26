package org.hchery.treeleaf.spring

import com.fasterxml.jackson.databind.ObjectMapper
import org.hchery.treeleaf.HttpBody
import org.hchery.treeleaf.java
import org.springframework.core.MethodParameter
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
private val SupportConverters = setOf(
    java<StringHttpMessageConverter>(),
    java<MappingJackson2HttpMessageConverter>(),
)

private val ServerHttpResponse.status: Int
    get() = (this as ServletServerHttpResponse).servletResponse.status

private val ServerHttpResponse.isRedirectResponse: Boolean
    get() = status / 100 == 3

private val ServerHttpResponse.isErrorResponse: Boolean
    get() = (status / 100).let { it == 4 || it == 5 }

@RestControllerAdvice
class HttpResponseBodyAdvice(objectMapper: ObjectMapper) : ResponseBodyAdvice<Any> {

    private val json = { data: Any? -> objectMapper.writeValueAsString(data) }

    override fun supports(
        returnType: MethodParameter,
        converterType: Class<out HttpMessageConverter<*>>
    ): Boolean {
        return converterType in SupportConverters
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        if (response.isRedirectResponse) {
            return body
        }
        if (response.isErrorResponse) {
            response.setStatusCode(HttpStatus.OK)
            if (body is HttpBody) {
                return body
            } else {
                val (code, desc) = (body as Map<*, *>).let {
                    val code = it["status"] as Int
                    val desc = "${it["path"]} ${it["error"]}"
                    return@let code to desc
                }
                return HttpBody(code, desc)
            }
        }
        if (body == null) {
            return HttpBody()
        }
        if (body is HttpBody) {
            return body
        }
        if (body is String) {
            response.headers.contentType = MediaType.APPLICATION_JSON
            return json(HttpBody(body))
        }
        return HttpBody(body)
    }
}
