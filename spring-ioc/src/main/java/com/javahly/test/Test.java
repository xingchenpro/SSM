package com.javahly.test;

import com.javahly.app.Appconfig;
import com.javahly.service.RoleService;
import com.javahly.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/16
 */
public class Test {

    public static void main(String[] args){
        //init Spring 环境
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        //System.out.println(ac.getBean(UserService.class));

        /*UserService u = ac.getBean(UserService.class);
        UserService u1 = ac.getBean(UserService.class);
        System.out.println(u==u1);*/

        //ac.getBean(RoleService.class);
        ac.getBean(UserService.class);

    }
}
