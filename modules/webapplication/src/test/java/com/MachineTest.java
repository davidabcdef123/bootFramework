package com;

import com.dave.sun.Application;
import com.dave.sun.enmu.Events;
import com.dave.sun.enmu.States;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Super.Sun on 2017/11/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MachineTest implements CommandLineRunner{
    @Autowired
    private StateMachine<States,Events> stateMachine;


    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }

    @Test
    public void machine(){
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}
