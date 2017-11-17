package com.dave.sun.rabbit;

import java.util.Date;

//@Component
public class Sender {

	/*@Autowired
	private AmqpTemplate rabbitTemplate;*/

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		//this.rabbitTemplate.convertAndSend("hello", context);
	}

}