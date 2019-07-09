package com.javahly.annotationBased.test;

import com.javahly.annotationBased.config.Appconfig;
import com.javahly.annotationBased.service.IndexDaoApplicationContextAware;
import com.javahly.annotationBased.service.IndexServiceLookup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/8
 * @QQ :1136513099
 * @desc :
 */
public class TestLockup {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);


        //单例Bean使用原型Bean
        //service只实例化一次，只有一次机会实例化dao
        IndexServiceLookup indexService1 = (IndexServiceLookup) applicationContext.getBean("indexServiceLookup");
        indexService1.service();
        IndexServiceLookup indexService2 = (IndexServiceLookup) applicationContext.getBean("indexServiceLookup");
        indexService2.service();
        System.out.println("----------------------------");


        IndexDaoApplicationContextAware indexDaoApplicationContextAware1 = (IndexDaoApplicationContextAware) applicationContext.getBean("indexDaoApplicationContextAware");
        indexDaoApplicationContextAware1.test();
        IndexDaoApplicationContextAware indexDaoApplicationContextAware2 = (IndexDaoApplicationContextAware) applicationContext.getBean("indexDaoApplicationContextAware");
        indexDaoApplicationContextAware2.test();

    }
}
