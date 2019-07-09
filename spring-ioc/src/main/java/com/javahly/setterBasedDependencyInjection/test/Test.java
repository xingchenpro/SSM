package com.javahly.setterBasedDependencyInjection.test;


import com.javahly.setterBasedDependencyInjection.bean.ExampleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/8
 * @QQ :1136513099
 * @desc :
 */
public class Test {

    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-setter-injection.xml");
        ExampleBean exampleBean = (ExampleBean) classPathXmlApplicationContext.getBean("exampleBean");
        exampleBean.test();
    }


}
