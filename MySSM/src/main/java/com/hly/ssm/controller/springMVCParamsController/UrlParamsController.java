package com.hly.ssm.controller.springMVCParamsController;

import com.hly.ssm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/12
 */
@Controller
@RequestMapping("urlParam")
public class UrlParamsController {

    @RequestMapping("/urlParam/{id}")
    public ModelAndView urlParams(@PathVariable("id") int id){
        User user = new User();
        user.setUserId(String.valueOf(id));
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setView(new MappingJackson2JsonView());
        return mv;

    }
}
