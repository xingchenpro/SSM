package com.dev.mode.test;

import com.dev.mode.CGLIB.CglibProxyExample;
import com.dev.mode.Interceptor.InterceptorJdkProxy;
import com.dev.mode.JdkAutoProxy.HelloWorld;
import com.dev.mode.JdkAutoProxy.HelloWorldImpl;
import com.sun.xml.internal.ws.api.message.HeaderList;

/**
 * @author :hly
 * @date :2018/5/1
 */
public class test {
    public static void main(String [] args){
        //new CglibProxyExample().testCGLIBProxy();
        /*调用真实对象前
        Hello 张三
        调用真实对象后*/
        /**
         * 责任链模式测试
         */
        /*HelloWorld proxy1 =(HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.dev.mode.COR.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,"com.dev.mode.COR.Interceptor2");
        HelloWorld proxy3 = (HelloWorld)InterceptorJdkProxy.bind(proxy2,"com.dev.mode.COR.Interceptor3");
        proxy3.sayHelloWorld();*/


    }
}
