package org.hchery.treeleaf.spring

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.context.ApplicationEvent

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Suppress("serial")
abstract class SpringEvent(src: Any) : ApplicationEvent(src)

@Suppress("serial")
abstract class AppEvent(src: Any) : ApplicationEvent(src)

@Suppress("serial")
class BeanFactoryPostEvent(
    src: Any,
    val beanFactory: ConfigurableListableBeanFactory
) : SpringEvent(src)