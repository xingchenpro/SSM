package com.hly.ssm.controller;

import com.hly.ssm.pojo.User;
import com.hly.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author :hly
 * @date :2018/5/14
 */
@Controller
@RequestMapping("/user")
public class RedirectController {
    @Autowired
    UserService userService;

    //1.字符串实现重定向
    @RequestMapping("/stringRir")
    public String addUser(Model model, String userId, String userNickName, String userPassword) {
        User user = new User(userId, userNickName, userPassword);
        userService.insertUser(user);
        model.addAttribute("userId", userId);
        model.addAttribute("userNickName", userNickName);
        model.addAttribute("userPassword", userPassword);
        System.out.println("rir:" + user.getUserNickName());
        return "redirect:./successByString";
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("/successByString")
    public ModelAndView successByString(String userId, String userNickName, String userPassword) {
        ModelAndView mv = new ModelAndView();
        //mv.setViewName("index");
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("userId", userId);
        mv.addObject("userNickName", userNickName);
        mv.addObject("userPassword", userPassword);
        System.out.println(userNickName);
        return mv;
    }

    //2.ModelAndView实现重定向
    @RequestMapping("/ModelRir")
    public ModelAndView addUser(ModelAndView mv, String userId, String userNickName, String userPassword) {
        User user = new User(userId, userNickName, userPassword);
        userService.insertUser(user);
        mv.addObject(user);
        mv.addObject("userId", userId);
        mv.addObject("userNickName", userNickName);
        mv.addObject("userPassword", userPassword);
        mv.setViewName("redirect:./successByModelView");
        return mv;
    }

    @RequestMapping("/successByModelView")
    public ModelAndView successByModelView(User user) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("user", user);
        return mv;
    }

    //addFlashAttribute传参数
    @RequestMapping("/FlashRir")
    public String addUserByFlash(RedirectAttributes ra,User user){
        userService.insertUser(user);
        ra.addFlashAttribute("user",user);
        return "redirect:./successByFlash";
    }

    @RequestMapping("/successByFlash")
    public ModelAndView successByFlash(User user) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("user", user);
        return mv;
    }

}
