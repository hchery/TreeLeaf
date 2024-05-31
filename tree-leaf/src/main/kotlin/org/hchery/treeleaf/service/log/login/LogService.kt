package org.hchery.treeleaf.service.log.login

import org.hchery.treeleaf.components.dao.Das
import org.hchery.treeleaf.dao.LoginLogDao
import org.hchery.treeleaf.db.log.LoginLog
import org.springframework.stereotype.Service

/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
class LoginLogService(dao: LoginLogDao) : Das<LoginLog, LoginLogDao>(dao)
