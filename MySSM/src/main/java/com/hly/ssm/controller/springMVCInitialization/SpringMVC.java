package com.hly.ssm.controller.springMVCInitialization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/4
 */
@Controller
@RequestMapping("SpringMVC")
public class SpringMVC {

    @RequestMapping("SpringMVC")
    //public ModelAndView springMVC(HttpServletRequest request){
    public ModelAndView springMVC(@RequestParam("id") String id){
        //System.err.println(request.getParameter("id"));
        System.err.println("id:"+id);

        ModelAndView mv  = new ModelAndView();
        mv.addObject("spring","spring");
        mv.setViewName("springMVC/springMVCInitialization/SpringMVC");
        return mv;
    }
}
