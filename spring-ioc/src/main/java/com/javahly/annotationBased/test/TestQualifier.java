package com.javahly.annotationBased.test;

import com.javahly.annotationBased.config.Appconfig;
import com.javahly.annotationBased.service.IndexServiceQualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :
 */
public class TestQualifier {

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        IndexServiceQualifier indexService = (IndexServiceQualifier) applicationContext.getBean("indexServiceQualifier");
        indexService.test();
    }
}
