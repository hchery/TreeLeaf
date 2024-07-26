package org.hchery.treeleaf.service.user

import org.hchery.treeleaf.components.dao.Das
import org.hchery.treeleaf.dao.UserDao
import org.hchery.treeleaf.db.user.User
import org.springframework.stereotype.Service

/**
 * DATE: 2024/5/25
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
class UserService(dao: UserDao) : Das<User, UserDao>(dao) {

    fun getByEmail(email: String): User? {
        return dao.searchIdByEmail(email)?.run { getById(id) }
    }
}

