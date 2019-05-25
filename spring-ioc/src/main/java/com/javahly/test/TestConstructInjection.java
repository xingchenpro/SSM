package com.javahly.test;

import com.javahly.service.IndexService;
import com.javahly.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/26
 * @QQ :1136513099
 * @desc :构造方法注入
 */
public class TestConstructInjection {

    public static void main(String[] args){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        UserService service = (UserService) classPathXmlApplicationContext.getBean("UserService");
        service.service();
    }
}
