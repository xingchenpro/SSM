package com.hly.ssm.controller.paramsController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/12
 */
@Controller
@RequestMapping("requestParam")
public class RequestParamsController {

    @RequestMapping("requestParam")
    public ModelAndView requestParams(@RequestParam(value = "user_id",required = false) String userId){
        System.out.println("user_id:"+userId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/springMVC/paramRequest/RequestParams");
        return mv;
    }
}
