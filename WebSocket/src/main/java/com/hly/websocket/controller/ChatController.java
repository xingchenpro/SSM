package com.hly.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * @author :hly
 * @date :2018/5/17
 * 作者博客：https://blog.csdn.net/Sirius_hly
 */
@Controller
@RequestMapping("/")
public class ChatController {

    @RequestMapping("/chat")
    public ModelAndView chat(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chat");
        return mv;
    }

    @RequestMapping(value = "/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/successLogin")
    public ModelAndView successLogin(String userId, String userPws, HttpSession httpSession){
        ModelAndView mv = new ModelAndView();
        if(userId.equals("123")&&userPws.equals("123")||userId.equals("12")&&userPws.equals("12")||userId.equals("1")&&userPws.equals("1")){
            httpSession.setAttribute("userId",userId);
            httpSession.setAttribute("login_status",true);
            mv.setViewName("chat");
            return mv;
        }
        mv.setViewName("login");
        return mv;
    }

}
