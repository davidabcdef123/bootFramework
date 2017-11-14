package com.dave.sun;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Super.Sun on 2017/11/11.
 */
@SpringBootApplication
@EnableWebMvc
@ComponentScan("com")
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
