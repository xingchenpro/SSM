package com.hly.ssm.controller;

import com.hly.ssm.pojo.User;
import com.hly.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @date :2018/5/13
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService = null;
    @RequestMapping("/login")
    public ModelAndView index(){
        //User user = userService.selectUserById("1");
        ModelAndView mvUser = new ModelAndView();
        //jsp文件名字
        mvUser.setViewName("login");
        //mvUser.addObject("user",user);
        return mvUser;
    }

    //字符串渲染视图
    @RequestMapping("/jstlView")
    public String jstl(ModelMap model){
        User user = new User("1","hly","123");
        model.addAttribute("user",user);
        return "index";
    }


}
