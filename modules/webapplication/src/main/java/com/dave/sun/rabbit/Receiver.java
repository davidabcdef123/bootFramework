package com.dave.sun.rabbit;

//@Component
//@RabbitListener(queues = "hello")
public class Receiver {

    //@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

}
