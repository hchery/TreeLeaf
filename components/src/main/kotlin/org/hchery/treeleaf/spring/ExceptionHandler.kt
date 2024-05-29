package org.hchery.treeleaf.spring

import jakarta.servlet.http.HttpServletRequest
import org.hchery.treeleaf.HttpBody
import org.hchery.treeleaf.error.BizException
import org.hchery.treeleaf.error.SeriousException
import org.hchery.treeleaf.error.TreeLeafException
import org.hchery.treeleaf.slf4j
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
private val log = slf4j<GlobalExceptionHandler>()

@RestControllerAdvice
class GlobalExceptionHandler {

    fun handleTreeLeafException(
        request: HttpServletRequest,
        ex: TreeLeafException,
        logging: (msg: String, error: Throwable?) -> Unit
    ): HttpBody {
        val msg = "Occur error: ${ex.message} {api: ${request.servletPath}}"
        logging(msg, ex)
        return HttpBody(ex.code, ex.desc)
    }

    @ExceptionHandler(BizException::class)
    fun handleBizException(
        request: HttpServletRequest,
        ex: BizException
    ): HttpBody {
        return handleTreeLeafException(request, ex) { msg, error ->
            log.warn(msg, error)
        }
    }

    @ExceptionHandler(SeriousException::class)
    fun handleSeriousException(
        request: HttpServletRequest,
        ex: SeriousException
    ): HttpBody {
        return handleTreeLeafException(request, ex) { msg, error ->
            log.error(msg, error)
        }
    }
}
