package com.dev.mode.JdkAutoProxy;

/**
 * @author :hly
 * @date :2018/5/1
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理中，实现代理逻辑类必须实现
 * java.lang.reflect.InvocationHandler接口，里面定义了invoke对象，提供接口数组用于下挂代理对象
 */
public class JdkProxyExample implements InvocationHandler {
    //真实对象，软件工程师对象
    private Object target = null;

    /**
     * @param target 保存真实对象
     * @return
     */
    //bind建立代理对象和真实对象的关系
    //相当于建立商务和软件工程师之间的代理关系
    public Object bind(Object target) {
        this.target = target;//
        //
        /**
         * newProxyInstance三个参数
         * 1.类加载器，采用target本身的类加载器
         * 2.生成动态代理对象下挂哪些接口下，
         * 3.定义逻辑代理类this代表当前对象，他必须实现InvocationHandler接口的invoke方法
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理逻辑方法的实现方法
     * invoke相当于商务逻辑，控制软件工程师的访问
     * @param proxy 代理对象，bind方法生成的对象，相当于商务对象
     * @param method 当前调度的方法
     * @param args 调度方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        //相当于调用sayHelloWorld方法
        Object object= method.invoke(target,args);
        System.out.println("在调用真实对象之后的服务");
        return object;
    }

    /**
     * 动态代理测试类
     */

    public void testJdkProxy(){
        JdkProxyExample jdk = new JdkProxyExample();
        //绑定关系，接口在HelloWorld下
        HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
        //此时，HelloWorld已经是一个代理对象，它会进入代理逻辑方法invoke
        proxy.sayHelloWorld();
    }
    public static void main(String []arvs){
        new JdkProxyExample().testJdkProxy();
    }
}
