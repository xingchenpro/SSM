package com.javahly.test;
import com.javahly.service.AnnotationBasedService;
import com.javahly.service.ConstructorInjectionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/26
 * @QQ :1136513099
 * @desc :annotation-based-----annotation 基于注解的编程风格
 */
public class AnnotationBasedTest {

    public static void main(String[] args){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-annotation-based.xml");
        AnnotationBasedService service = (AnnotationBasedService) classPathXmlApplicationContext.getBean("annotationBasedService");
        service.service();
    }
}
