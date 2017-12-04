package com.dave.sun.action;

import com.alibaba.fastjson.JSON;
import com.dave.sun.common.config.error.MyException;
import com.dave.sun.dao.mongo.primary.UserDao;
import com.dave.sun.service.IDemoService;
import com.dave.sun.vo.User;
import com.dave.sun.vo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Super.Sun on 2017/11/11.
 */
@Controller
public class DemoController {

    @Autowired
    IDemoService demoService;

    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.put("username", "张三");
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        modelMap.put("list1", list);
        modelMap.put("sex", 1);
        return "index";
    }

    @GetMapping("getList")
    public String getList() {
        return "list";
    }

    @PostMapping("listData")
    public String getListData(ModelMap modelMap, int pagesize, int pagenum) {
        List<User> list = demoService.selectUserPage(pagenum, pagesize);
        return JSON.toJSONString(list);
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
    public String redisAdd() {
        demoService.redisAdd();
        return "";
    }

    @RequestMapping("deleteByPrimaryKey")
    @ResponseBody
    public String deleteByPrimaryKey() {
        return demoService.deleteByPrimaryKey() + "";
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert() {
        return demoService.insert() + "";
    }

    @RequestMapping("insertSelective")
    @ResponseBody
    public String insertSelective() {
        return demoService.insertSelective() + "";
    }

    @RequestMapping(value = "selectByPrimaryKey", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectByPrimaryKey() {
        String result = demoService.selectByPrimaryKey().getName();
        return result;
    }

    @RequestMapping("updateByPrimaryKeySelective")
    @ResponseBody
    public String updateByPrimaryKeySelective() {
        return demoService.updateByPrimaryKeySelective() + "";
    }

    @RequestMapping("selectByExample")
    @ResponseBody
    public String selectByExample() {
        return demoService.selectByExample().size() + "";
    }

    @GetMapping("testCinaese")
    @ResponseBody
    public String testCinaese(String name) {
        System.out.println(name);
        return "";
    }

    @GetMapping("datesource1")
    @ResponseBody
    public String datesource1() {
        demoService.datesource1();
        return "";
    }

    @GetMapping("datesource2")
    @ResponseBody
    public String datesource2() {
        demoService.datesource2();
        return "";
    }

    @GetMapping("add")
    public String add(@Valid UserEntity userEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // return bindingResult.getFieldError().getDefaultMessage();
            return "paramerror";
        } else {
            return "index";
        }
    }

    @GetMapping("mongoaddUser")
    @ResponseBody
    public String mongoaddUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("11111@qq.com");
        userEntity.setUserName("张三");
        userEntity.setId("21");
        userDao.saveUser(userEntity);
        return "";
    }

    @GetMapping("delUser")
    @ResponseBody
    public String delUser() {
        userDao.deleteUserById("21");
        return "";
    }

    @GetMapping("findUserByUserName")
    @ResponseBody
    public String findUserByUserName(String username) {
        userDao.findUserByUserName(username);
        return "";
    }

    @GetMapping("updateUser")
    @ResponseBody
    public String updateUser(String username) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(username);
        userEntity.setId("21");
        userDao.updateUser(userEntity);
        return "";
    }
}
