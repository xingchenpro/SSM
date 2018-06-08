package com.hly.SpringMVC.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @date :2018/5/12
 */
//表明它是一个控制器
@Controller("myController")
//请求的url在/user下才有该控制器相应
@RequestMapping("/")
public class MyController {
    //URL是/index的时候该方法才请求,都改成/，直接运行就能显示界面
    @RequestMapping("/")
    public ModelAndView index(){
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //视图名称为index
        mv.setViewName("test");
        return mv;
    }
    //只有点击内部逻辑才能访问，直接输入地址不能访问
    @RequestMapping(value = "test3",method = RequestMethod.POST)
    public ModelAndView test2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test2");
        return mv;
    }

}
