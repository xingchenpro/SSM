package com.hly.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @date :2018/5/12
 */
//表明它是一个控制器
@Controller("myController")
//请求的url在/user下才有该控制器相应
@RequestMapping("/user")
public class MyController {
    //URL是/index的时候该方法才请求,都改成/，直接运行就能显示界面
    @RequestMapping("/index")
    public ModelAndView index(){
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //视图名称为index
        mv.setViewName("login/index");
        return mv;
    }
}
