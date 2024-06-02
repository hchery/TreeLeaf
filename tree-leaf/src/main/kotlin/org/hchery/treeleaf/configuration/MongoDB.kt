package org.hchery.treeleaf.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import org.springframework.data.mongodb.core.mapping.MongoMappingContext
import org.springframework.transaction.TransactionManager

/**
 * DATE: 2024/5/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

@Configuration(proxyBeanMethods = false)
class MongoDBRemoveClassFieldConfigurer {

    @Bean
    fun mappingMongoConverter(
        ctx: MongoMappingContext,
        factory: MongoDatabaseFactory,
        cc: MongoCustomConversions
    ): MappingMongoConverter {
        val dbRefResolver = DefaultDbRefResolver(factory)
        return MappingMongoConverter(dbRefResolver, ctx)
            .apply {
                setCustomConversions(cc)
                setTypeMapper(DefaultMongoTypeMapper(null))
            }
    }
}

@Configuration(proxyBeanMethods = false)
class MongoDBTransactionalManagerConfigurer {

    @Bean
    fun transactionManager(factory: MongoDatabaseFactory): TransactionManager {
        return MongoTransactionManager(factory)
    }
}
