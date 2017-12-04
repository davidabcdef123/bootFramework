package com.dave.sun.common.config.db.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Super.Sun on 2017/12/4.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.dave.sun.dao.mongo.primary",
        mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {

    protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}
