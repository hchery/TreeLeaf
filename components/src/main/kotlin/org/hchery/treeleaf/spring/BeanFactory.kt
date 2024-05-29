package org.hchery.treeleaf.spring

import org.hchery.treeleaf.slf4j
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
private val log = slf4j<BeanFactoryEventPostProcessor>()

@Component
class BeanFactoryEventPostProcessor : BeanFactoryPostProcessor, ApplicationContextAware {

    private lateinit var applicationContext: ApplicationContext

    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        val event = BeanFactoryPostEvent(this, beanFactory)
        if (log.isDebugEnabled) {
            log.debug("Publish bean factory post event.")
        }
        applicationContext.publishEvent(event)
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        if (log.isDebugEnabled) {
            log.debug("Inject application context.")
        }
        this.applicationContext = applicationContext
    }
}
