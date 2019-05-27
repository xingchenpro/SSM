package com.javahly.test;
import com.javahly.service.SetterInjectionService;
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
public class SetterInjectionTest {

    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-setter-injection.xml");
        SetterInjectionService service = (SetterInjectionService) classPathXmlApplicationContext.getBean("setterService");
        service.service();
    }
}
