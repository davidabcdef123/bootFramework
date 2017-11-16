package com;

import com.dave.sun.action.DemoController;
import com.dave.sun.service.IDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Super.Sun on 2017/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test3 {

    @Autowired
    IDemoService demoService;

    @Test
    public void test(){
        System.out.println(demoService);
    }
}
