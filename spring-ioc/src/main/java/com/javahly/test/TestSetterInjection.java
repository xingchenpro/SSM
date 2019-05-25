package com.javahly.test;

import com.javahly.service.IndexService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/25
 * @QQ :1136513099
 * @desc :Setter注入测试
 */
public class TestSetterInjection {


    public static void main(String[] args){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        IndexService service = (IndexService) classPathXmlApplicationContext.getBean("IndexService");
        service.service();

    }
}
