package org.hchery.treeleaf.service.user

import org.hchery.treeleaf.db.user.User
import org.hchery.treeleaf.slf4j
import org.hchery.treeleaf.stringRandom
import org.springframework.beans.factory.InitializingBean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

private const val DefaultAdminEmail = "admin@default.tf"
private const val DefaultAdminNick = "Administrator"

private val log = slf4j<AdminUserAutoConfigureService>()

@Service
class AdminUserAutoConfigureService(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder,
) : InitializingBean {

    override fun afterPropertiesSet() {
        val user = userService.getByEmail(DefaultAdminEmail)
        if (user != null) {
            return
        }
        autoGenerateAdmin()
    }

    private fun autoGenerateAdmin() {
        val admin = User().apply {
            email = DefaultAdminEmail
            nickname = DefaultAdminNick
            password = stringRandom()
        }
        log.info("""No admin account configured, auto generated.
            |
            |Auto generated admin account:
            |Email: ${admin.email}
            |Password: ${admin.password}
            |
        """.trimMargin())
        userService.save(admin.apply { password = passwordEncoder.encode(password) })
    }
}

