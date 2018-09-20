package com.hly.ssm.controller.springMVCParamsController;

import com.hly.ssm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/13
 */
@Controller
@RequestMapping("listParam")
public class ListParamsController {

    /**
     * 传递数组
     * @param myList
     * @return
     */
    @RequestMapping("listParam")
    public ModelAndView listParams(@RequestBody List<Integer> myList){
        System.out.println(myList.toString());
        ModelAndView mv = new ModelAndView();
        mv.addObject("myList",myList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }


    /**
     * 传递对象数组
     * @param usersList
     * @return
     */
    @RequestMapping("userListParam")
    public ModelAndView userListParams(@RequestBody List<User> usersList){
        System.out.println(usersList.toString());
        ModelAndView mv = new ModelAndView();
        mv.addObject("usersList",usersList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("formParam")
    public ModelAndView formParams(String userId,String userPassword){
        System.out.println(userId+" "+userPassword);
        ModelAndView mv = new ModelAndView();
        return mv;

    }



    @RequestMapping("listStart")
    public ModelAndView jsonStart() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/springMVC/paramRequest/ListParams");
        return mv;
    }







}
