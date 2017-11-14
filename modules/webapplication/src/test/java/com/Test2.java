package com;

import com.dave.sun.Application;
import com.dave.sun.IDemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Super.Sun on 2017/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class Test2 {

    @Autowired
    @Qualifier("dao1")
    IDemoMapper demoMapper;

    @Test
    @Rollback
    public void add(){
        demoMapper.insert("张三", 11);
    }




}
