package com.hly.ssm.controller.springMVCParamsController;

import com.hly.ssm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("jsonParam")
public class JSONParamsController {

    @RequestMapping("jsonParam")
    public ModelAndView jsonParam(@RequestBody User user) {

        System.out.println(user.toString());
        ModelAndView mv = new ModelAndView();
        //mv.addObject(json);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("jsonStart")
    public ModelAndView jsonStart() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/springMVC/paramRequest/JSONParams");
        return mv;
    }
}
