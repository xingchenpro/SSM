package com.hly.ssm.springAOP.springAOPProxy;

import com.hly.ssm.pojo.User;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/22
 */
public class TestSpringAOP {

    public static void main(String[] args){

        UserService userService = new UserServiceImpl();
        ProxyInterceptor interceptor = new ProxyInterceptorImpl();
        UserService proxy = ProxyBeanFactory.getBean(userService,interceptor);
        User user = new User("001","hly","123");
        //进入invoke
        proxy.printUser(user);
        System.err.println("----------测试----------");
        user = null;
        proxy.printUser(user);

    }
}
