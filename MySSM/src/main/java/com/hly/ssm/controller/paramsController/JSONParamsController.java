package com.hly.ssm.controller.paramsController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hly.ssm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
    public ModelAndView jsonParam(@RequestBody User user){
//String userId,@RequestBody String userNickName,@RequestBody String userPassword





        System.out.println(user.getUserId());
        //System.out.println(userId+userNickName+userPassword);


        ModelAndView mv = new ModelAndView();
        //mv.addObject(json);
       mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("jsonStart")
    public ModelAndView jsonStart(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/springMVC/paramRequest/JSONParams");
        return mv;
    }
}
