package com.hly.ssm.controller.paramsController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/12
 */
@Controller
@RequestMapping("commonParam")
public class CommonParamsController {

    @RequestMapping("commonParam")
    public ModelAndView commonParam(String user_id,String user_password){
        System.out.println("user_id:"+user_id);
        System.out.println("user_password:"+user_password);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/springMVC/paramRequest/CommonParams");
        return mv;
    }

}
