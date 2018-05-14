package com.hly.ssm.controller;

import com.hly.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @date :2018/5/13
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService = null;
    @RequestMapping("/")
    public ModelAndView index(){
        //User user = userService.selectUserById("1");
        ModelAndView mvUser = new ModelAndView();
        //jsp文件名字
        mvUser.setViewName("login");
        //mvUser.addObject("user",user);
        return mvUser;
    }
}
