package com.hly.ssm.controller;

import com.hly.ssm.pojo.User;
import com.hly.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @author :hly
 * @date :2018/5/13
 */
@Controller
@RequestMapping("/params")
public class ParamsController {
    @RequestMapping("/commonParams")
    public ModelAndView commonParams(@RequestParam(value = "userId", required = false) String userId, String userNickName, String userPassword) {
        //参数名称要和http传来的参数名称保持一致
        System.out.println("userId:" + userId);
        System.out.println("userNickName:" + userNickName);
        System.out.println("userPassword:" + userPassword);
        ModelAndView mv = new ModelAndView();
        User user = new User(userId, userNickName, userPassword);
        mv.addObject(user);
        mv.setViewName("index");
        return mv;
    }

    //根据Id查询
    @Autowired
    UserService userService;

    //参数名称为user_id
    @RequestMapping("/getUser/{id}")
    //@PathVariable表示从URL请求地址中获取参数
    public ModelAndView pathVariable(@PathVariable("id") String userId) {
        User user = userService.selectUserById(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    //无法实现
    @RequestMapping("/findUser")
    public ModelAndView findUser(@RequestBody User user) {
        //List<User> userList = userService.
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    //无法实现
    @RequestMapping("commonParamsPojo")
    public ModelAndView commonParamsPojo(String userId, String userNickName, String userPassword) {
        System.out.println(userId + " " + userNickName + " " + userPassword);
        ModelAndView mv = new ModelAndView();
        User user = new User(userId, userNickName, userPassword);
        mv.addObject(user);
        mv.setViewName("index");
        return mv;
    }


}
