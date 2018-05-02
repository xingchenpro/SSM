package com.dev.mode.Interceptor;

import com.dev.mode.JdkAutoProxy.HelloWorld;
import com.dev.mode.JdkAutoProxy.HelloWorldImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @date :2018/5/1
 */
//在jdk动态代理中使用拦截器
public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;//真实对象
    private String interceptorClass = null;//拦截器全限定名

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target,String interceptorClass){
        //返回代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InterceptorJdkProxy(target,interceptorClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass==null){
            //没有拦截器则直接反射原有方法，然后结束
            return method.invoke(target,args);
        }
        Object result = null;
        //通过反射生成拦击诶器，准备使用它
        Interceptor interceptor = (Interceptor)Class.forName(interceptorClass).newInstance();
        //调用前置方法
        if(interceptor.before(proxy,target,method,args)){
            //返回原有对象方法
            result = method.invoke(target,args);
        }
        else{
            //返回false执行的around方法
            interceptor.around(proxy,target,method,args);
        }
        //调用后置方法
        interceptor.after(proxy,target,method,args);
        return result;
    }

    public static void main(String []args){
        HelloWorld proxy = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.dev.mode.Interceptor.MyInterceptor");
        //interceptorClass为null时输出
        proxy.sayHelloWorld();
    }
}
