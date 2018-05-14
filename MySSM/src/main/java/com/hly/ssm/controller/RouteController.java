package com.hly.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @date :2018/5/14
 */
@Controller
@RequestMapping("/")
public class RouteController {
    @RequestMapping("/")
    public ModelAndView from(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
