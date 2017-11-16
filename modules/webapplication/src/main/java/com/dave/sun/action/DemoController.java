package com.dave.sun.action;

import com.dave.sun.common.config.error.MyException;
import com.dave.sun.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Super.Sun on 2017/11/11.
 */
@Controller
public class DemoController {

    @Autowired
    IDemoService demoService;

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

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("redis/add")
    @ResponseBody
    public String redisAdd(){
        demoService.redisAdd();
        return "";
    }

    @RequestMapping("deleteByPrimaryKey")
    @ResponseBody
    public String deleteByPrimaryKey(){
        return demoService.deleteByPrimaryKey()+"";
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(){
        return demoService.insert()+"";
    }

    @RequestMapping("insertSelective")
    @ResponseBody
    public String insertSelective(){
        return demoService.insertSelective()+"";
    }

    @RequestMapping(value="selectByPrimaryKey",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String selectByPrimaryKey(){
        String result=demoService.selectByPrimaryKey().getName();
        return result;
    }

    @RequestMapping("updateByPrimaryKeySelective")
    @ResponseBody
    public String updateByPrimaryKeySelective(){
        return demoService.updateByPrimaryKeySelective()+"";
    }

    @RequestMapping("selectByExample")
    @ResponseBody
    public String selectByExample(){
        return demoService.selectByExample().size()+"";
    }

    @GetMapping("testCinaese")
    @ResponseBody
    public String testCinaese(String name){
        System.out.println(name);
        return "";
    }
}
