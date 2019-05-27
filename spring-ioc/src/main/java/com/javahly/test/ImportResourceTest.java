package com.javahly.test;

import com.javahly.app.Appconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/16
 */
public class ImportResourceTest {

    public static void main(String[] args){
        //init Spring 环境
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

    }
}
