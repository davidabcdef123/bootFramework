package com.dave.sun;

import com.dave.sun.common.config.db.mongodb.MultipleMongoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Super.Sun on 2017/11/11.
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
//@EnableWebMvc
//@ComponentScan("com")
//@MapperScan(basePackages = {"com.dave.sun.dao"})
@ServletComponentScan
public class Application {

    public static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Springboot Application started! 嘿嘿嘿");
    }
}
