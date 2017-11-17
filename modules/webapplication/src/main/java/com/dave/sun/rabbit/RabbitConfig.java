package com.dave.sun.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by Super.Sun on 2017/11/17.
 * 待测没验证
 */
//@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
