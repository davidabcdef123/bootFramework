package com.dave.sun.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Super.Sun on 2017/11/11.
 */
@Controller
public class DemoController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/aaa")
    public String aaa(){
        return "index";
    }

}
