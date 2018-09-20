package com.hly.ssm.transaction;

import com.hly.ssm.pojo.User;
import com.hly.ssm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/20
 */
public class TransactionTest {

    @Test
    public void testSelectTransation(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        UserService userService = ctx.getBean(UserService.class);
        User user = userService.selectUserById("001");
        System.out.println(user.toString());

    }

    @Test
    public void testInsertTransation(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        UserService userService = ctx.getBean(UserService.class);
        User user = new User("001","hly","123");
        userService.insertUser(user);



    }



}
