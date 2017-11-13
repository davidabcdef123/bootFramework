package com.dave.sun.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Super.Sun on 2017/11/11.
 */
@Controller
public class DemoController {

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        modelMap.put("username","张三");
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        modelMap.put("list1", list);
        modelMap.put("sex",1);
        return "index";
    }

    @RequestMapping("/aaa")
    public String aaa(){
        return "index";
    }

}
