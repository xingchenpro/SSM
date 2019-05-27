package com.javahly.test;

import com.javahly.app.Appconfig;
import com.javahly.service.JavaBasedService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/26
 * @QQ :1136513099
 * @desc :java-based----java Configuration 编程风格
 */
public class JavaBasedTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("AppConfig1");
        annotationConfigApplicationContext.register(Appconfig.class);
        annotationConfigApplicationContext.refresh();
        JavaBasedService javaBasedService = (JavaBasedService) annotationConfigApplicationContext.getBean("javaBasedService");
        javaBasedService.service();
    }
}
