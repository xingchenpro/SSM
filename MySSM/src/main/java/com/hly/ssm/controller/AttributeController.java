package com.hly.ssm.controller;

import com.hly.ssm.pojo.User;
import com.hly.ssm.service.UserService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.jws.WebParam;

/**
 * @author :hly
 * @date :2018/5/14
 */
@Controller
@RequestMapping("/attribute")
//@SessionAttributes(names = {"id"},types = {User.class})
public class AttributeController {
    @Autowired
    UserService userService;

   @RequestMapping("/sessionAttribute")
    public ModelAndView sessionAttribute(String id){
       ModelAndView mv = new ModelAndView();
       User user = userService.selectUserById(id);
       System.out.println(user.getUserNickName());
       mv.setView(new MappingJackson2JsonView());
       //根据类型Session保存角色信息
       mv.addObject("user",user);
       return mv;
   }

   @RequestMapping("/RequestAttribute")
    public ModelAndView requestAttribute(@RequestHeader ("id")String userId){
       ModelAndView mv = new ModelAndView();
       User user = userService.selectUserById(userId);
       mv.addObject("user",user);
       mv.setView(new MappingJackson2JsonView());
       return mv;
   }


}
