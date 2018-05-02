package com.dev.mode.JdkAutoProxy;

/**
 * @author :hly
 * @date :2018/5/1
 */

/**
 * 实现类
 * 此时可以开始动态代理了
 */
public class HelloWorldImpl implements HelloWorld{

    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
